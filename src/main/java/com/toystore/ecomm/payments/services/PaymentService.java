package com.toystore.ecomm.payments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.toystore.ecomm.payments.constants.PPMSConstants;
import com.toystore.ecomm.payments.model.PaymentInfo;
import com.toystore.ecomm.payments.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;

	public PaymentInfo savePaymentInfo(PaymentInfo paymentInfo) throws StripeException {
		Stripe.apiKey = "sk_test_51HOi5SGpfnkrm8HZQY5SsL5g62yJAUaXhtnu1bk1pjNgL9uzticGidhfCMFUSR9WkbZNhAlOGJcPA4UQGefwE89s00g0oKuGxn";

		/*
		 * PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
		 * .setAmount(1000L) .setCurrency("inr") .addPaymentMethodType("card")
		 * .setReceiptEmail("jenny.rosen@example.com") .build();
		 * 
		 * PaymentIntent paymentIntent = PaymentIntent.create(params);
		 */
		
		SessionCreateParams.Mode mode = SessionCreateParams.Mode.PAYMENT;
		
		switch (paymentInfo.getPaymentMode()) {
			case PPMSConstants.PAYMENT_MODE: mode = SessionCreateParams.Mode.PAYMENT; break;
			case PPMSConstants.SETUP_MODE: mode = SessionCreateParams.Mode.SETUP; break;
			case PPMSConstants.SUBSCRIPTION_MODE: mode = SessionCreateParams.Mode.SUBSCRIPTION; break;
		}
		 
		SessionCreateParams params = SessionCreateParams.builder()
	    	          				 .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
	    	          				 .setMode(mode)
	    	          				 .setSuccessUrl("https://example.com/success")
	    	          				 .setCancelUrl("https://example.com/cancel")
	    	          				 .addLineItem(SessionCreateParams.LineItem.builder()
	    	          						  	  .setQuantity(1L)
	    	          						  	  .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
	    	          						  			   		.setCurrency("usd")
	    	          						  			   		.setUnitAmount(2000L)
	    	          						  			   		.setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
	    	          						  			   						.setName("T-shirt")
	    	          						  			   						.build())
	    	          						  			   		.build())
	    	          						  	  .build())
	    	          				  .build();

	      Session session = Session.create(params);
	      
	      paymentInfo.setPaymentSessionId(session.getId());
	      paymentInfo.setStatus(session.getPaymentStatus());
	      paymentInfo.setPaymentMethod(session.getPaymentMethodTypes().get(0));
	      
	      return paymentRepository.save(paymentInfo);
	      
	      
	}
}
