package com.toystore.ecomm.payments.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Event;
import com.stripe.model.Invoice;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentMethod;
import com.stripe.model.StripeObject;
import com.stripe.model.Subscription;
import com.stripe.net.RequestOptions;
import com.stripe.param.PaymentMethodAttachParams;
import com.toystore.ecomm.payments.constants.PPMSConstants;
import com.toystore.ecomm.payments.exception.NotFoundException;
import com.toystore.ecomm.payments.factory.POJOFactory;
import com.toystore.ecomm.payments.model.SubscriptionCustomerInfo;
import com.toystore.ecomm.payments.model.SubscriptionPaymentInfo;
import com.toystore.ecomm.payments.model.SubscriptionProductInfo;
import com.toystore.ecomm.payments.repository.SubscriptionPaymentRepository;
import com.toystore.ecomm.payments.util.DateFormatter;

@Service
public class SubscriptionPaymentService {

	@Autowired
	private SubscriptionPaymentRepository paymentRepository;

	@Autowired
	private SubscriptionProductService productService;

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	JmsTemplate jmsTemplate;

	public SubscriptionPaymentInfo saveSubscriptionPaymentInfo(Integer custId, String planType, String renewalType,
			Integer trialDays, String method, String cardToken, String cancelAtPeriodEnd)
			throws StripeException, ParseException, IllegalAccessException, InstantiationException {
		Stripe.apiKey = "sk_test_51HOi5SGpfnkrm8HZQY5SsL5g62yJAUaXhtnu1bk1pjNgL9uzticGidhfCMFUSR9WkbZNhAlOGJcPA4UQGefwE89s00g0oKuGxn";

		// Get the Stripe Customer ID & Txn Key from DB (Cache)
		SubscriptionCustomerInfo customer = (customerService.getAllCustomerInfo().stream()
				.filter(c -> c.getSubscriptionCustomerId() == custId).findFirst()).get();
		Integer subscriptionCustomerId = customer.getSubscriptionCustomerId();
		String customerId = customer.getCustomerId();
		String txnKey = customer.getTxnKey();

		// Get the Stripe Product ID & Price ID from DB (Cache)
		SubscriptionProductInfo product = (productService.getAllSubscriptionProductInfo().stream()
				.filter(p -> (p.getPlanType().equalsIgnoreCase(planType.trim())
						&& p.getRenewalType().equalsIgnoreCase(renewalType.trim())))
				.findFirst()).get();
		String productId = product.getProductId();
		String priceId = product.getPriceId();

		// Deactivate/Cancel, if any, existing Active Subscription - START
		List<String> statusList = new ArrayList<String>(2);
		statusList.add(PPMSConstants.TRIAL_STATUS);
		statusList.add(PPMSConstants.ACTIVE_STATUS);

		List<SubscriptionPaymentInfo> paymentInfoList = paymentRepository
				.findBySubscriptionCustomerIdNStatus(subscriptionCustomerId, statusList);

		if (!paymentInfoList.isEmpty()) {
			SubscriptionPaymentInfo paymentInfo = paymentInfoList.get(0);

			if (!paymentInfo.getSubscriptionProductInfo().getProductId().equalsIgnoreCase(productId)) {
				txnKey = UUID.randomUUID().toString();

				// Cancel the Subscription in Stripe
				Subscription subscription = Subscription.retrieve(paymentInfo.getSubscriptionId());
				subscription.cancel();

				// In-activate the Subscription by updating the Status in DB
				customer.setTxnKey(txnKey);
				paymentInfo.setSubscriptionCustomerInfo(customer);
				paymentInfo.setSubscriptionStatus(PPMSConstants.INACTIVE_STATUS);
				paymentRepository.save(paymentInfo);
			}
		}
		// Deactivate/Cancel, if any, existing Active Subscription - END

		// Create 'SUBSCRIPTION' in STRIPE - START
		Map<String, Object> subscriptionParams = new HashMap<>();
		subscriptionParams.put("customer", customerId);

		List<Object> items = new ArrayList<>();
		Map<String, Object> item1 = new HashMap<>();
		item1.put("price", priceId);
		items.add(item1);

		subscriptionParams.put("items", items);

		// If NOT Trial Period
		if (trialDays == null) {
			Map<String, Object> card = new HashMap<>();
			card.put("token", cardToken);

			Map<String, Object> paymentMethodParams = new HashMap<>();
			paymentMethodParams.put("type", "card");
			paymentMethodParams.put("card", card);

			PaymentMethod paymentMethod = PaymentMethod.create(paymentMethodParams);

			PaymentMethodAttachParams paymentMethodAttachParams = PaymentMethodAttachParams.builder()
					.setCustomer(customerId).build();
			paymentMethod = paymentMethod.attach(paymentMethodAttachParams);

			subscriptionParams.put("cancel_at_period_end", cancelAtPeriodEnd.equals("Y") ? true : false);
			subscriptionParams.put("default_payment_method", paymentMethod.getId());
		} else { // If Trial Period
			subscriptionParams.put("trial_period_days", 15);
		}

		// For Idempotency
		RequestOptions options = RequestOptions.builder().setIdempotencyKey(txnKey).build();

		Subscription subscription = Subscription.create(subscriptionParams, options);
		// Create 'SUBSCRIPTION' in STRIPE - END

		// Retrieve 'INVOICE' & 'PAYMENTINTENT' from STRIPE
		Invoice invoice = Invoice.retrieve(subscription.getLatestInvoice());

		// Save Required info into DB - START
		SubscriptionPaymentInfo paymentInfo = (SubscriptionPaymentInfo) POJOFactory
				.getInstance("SUBSCRIPTIONPAYMENTINFO");

		// STRIPE SUBSCRIPTION ID
		paymentInfo.setSubscriptionId(subscription.getId());

		// STRIPE SUBSCRIPTION STATUS
		paymentInfo.setSubscriptionStatus(subscription.getStatus());

		// SUBSCRIPTION CHARGE (AMOUNT)
		paymentInfo.setAmount(subscription.getItems().getData().get(0).getPrice().getUnitAmountDecimal().doubleValue());

		// STRIPE INVOICE STATUS
		paymentInfo.setInvoiceStatus(invoice.getStatus());

		// DB CUSTOMER ID
		paymentInfo.setSubscriptionCustomerId(customer.getSubscriptionCustomerId());

		// DB PRODUCT ID
		paymentInfo.setSubscriptionProductId(product.getSubscriptionProductId());

		// STRIPE INVOICE ID
		paymentInfo.setInvoiceId(subscription.getLatestInvoice());

		// WHETHER TO CANCEL SUBSCRIPTION POST EXPIRY
		paymentInfo.setCancelAtPeriodEnd(
				(subscription.getCancelAtPeriodEnd() != null) ? (subscription.getCancelAtPeriodEnd() ? "Y" : "N")
						: null);

		if (trialDays == null) {
			PaymentIntent paymentIntent = PaymentIntent.retrieve(invoice.getPaymentIntent());

			// STRIPE PAYMENTINTENT ID
			paymentInfo.setPaymentIntentId(paymentIntent.getId());

			// STRIPE PAYMENTINTENT STATUS
			paymentInfo.setPaymentIntentStatus(paymentIntent.getStatus());

			// SUBSCRIPTION START DATE
			paymentInfo.setSubscriptionStart(DateFormatter.format(subscription.getCurrentPeriodStart()));

			// SUBSCRIPTION END DATE
			paymentInfo.setSubscriptionEnd(DateFormatter.format(subscription.getCurrentPeriodEnd()));
		} else {
			// SUBSCRIPTION (Trial) START DATE
			paymentInfo.setTrialStart(DateFormatter.format(subscription.getTrialStart()));

			// SUBSCRIPTION (Trial) END DATE
			paymentInfo.setTrialEnd(DateFormatter.format(subscription.getTrialEnd()));
		}

		// SUBSCRIPTION PAYMENT METHOD
		paymentInfo.setPaymentMethod(method);

		// Save Required info into DB - END

		return paymentRepository.save(paymentInfo);
	}

	public Optional<SubscriptionPaymentInfo> removeSubscriptionPaymentInfo(Integer subscriptionPaymentId)
			throws StripeException, NotFoundException {
		Stripe.apiKey = "sk_test_51HOi5SGpfnkrm8HZQY5SsL5g62yJAUaXhtnu1bk1pjNgL9uzticGidhfCMFUSR9WkbZNhAlOGJcPA4UQGefwE89s00g0oKuGxn";

		Optional<SubscriptionPaymentInfo> paymentInfoOpt = paymentRepository.findById(subscriptionPaymentId);

		if (paymentInfoOpt.isPresent()) {
			SubscriptionPaymentInfo paymentInfo = paymentInfoOpt.get();

			// Cancel the Subscription in Stripe
			Subscription subscription = Subscription.retrieve(paymentInfo.getSubscriptionId());
			subscription.cancel();

			// In-activate the Subscription by updating the Status in DB
			paymentInfo.setSubscriptionStatus(PPMSConstants.INACTIVE_STATUS);
			paymentRepository.save(paymentInfo);

			// Set the Txn Key to NULL
			SubscriptionCustomerInfo customerInfo = customerService
					.getCustomerInfoById(paymentInfo.getSubscriptionCustomerId()).get();
			customerInfo.setTxnKey(null);

			customerService.updateCustomerInfo(customerInfo);

			return Optional.of(paymentInfo);
		}

		return paymentInfoOpt;
	}

	public void notifyPaidSubscriptionExpiring(Customer stripeCustomer) {
		Optional<SubscriptionCustomerInfo> customerInfo = customerService.getCustomerInfoByCustomerId(stripeCustomer.getId());
		
		if (customerInfo.isPresent()) {
			Integer ppmsCustId = customerInfo.get().getSubscriptionCustomerId();
			
			jmsTemplate.convertAndSend(ppmsCustId.toString());
		}
	}
	
	
	
	/***********************************************************************************************************************************/
	
	@Value("${proarchs.activemq.queue.stripe_event}")
	private String stripeEventQName;

	@JmsListener(destination = "${proarchs.activemq.queue.stripe_event}", containerFactory = "paymentDefaultJmsListenerContainerFactory")
	public void receiveStripeEvents(Event requestPayload) {
		//log.info("received order='{}'", order);
		System.out.println("Event Object: " + requestPayload);
		
	}
}
