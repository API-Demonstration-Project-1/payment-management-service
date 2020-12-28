package com.toystore.ecomm.payments.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
import com.toystore.ecomm.payments.factory.POJOFactory;
import com.toystore.ecomm.payments.model.SubscriptionCustomerInfo;
import com.toystore.ecomm.payments.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public SubscriptionCustomerInfo saveCustomerInfo (String customerName) throws StripeException, IllegalAccessException, InstantiationException {
		Stripe.apiKey = "sk_test_51HOi5SGpfnkrm8HZQY5SsL5g62yJAUaXhtnu1bk1pjNgL9uzticGidhfCMFUSR9WkbZNhAlOGJcPA4UQGefwE89s00g0oKuGxn";

		CustomerCreateParams customerParams = CustomerCreateParams.builder()
			  	  							  .setName(customerName).build();

		Customer customer = Customer.create(customerParams);
		
    	SubscriptionCustomerInfo customerInfo = (SubscriptionCustomerInfo)POJOFactory.getInstance("SUBSCRIPTIONCUSTOMERINFO");
		customerInfo.setCustomerName(customerName);
		customerInfo.setCustomerId(customer.getId());
		customerInfo.setTxnKey(UUID.randomUUID().toString());
		
	    return customerRepository.save(customerInfo);
	}
	
	@CachePut("subscriptionCustomers")
	public List<SubscriptionCustomerInfo> getAllCustomerInfo() {
		List<SubscriptionCustomerInfo> subscriptionCustomerInfoList = new ArrayList<SubscriptionCustomerInfo>();
		
		customerRepository.findAll().forEach(subscriptionCustomerInfoList::add);
		
		return subscriptionCustomerInfoList;
	}
	
	public Optional<SubscriptionCustomerInfo> getCustomerInfoById(Integer customerId) {
		return customerRepository.findById(customerId);
	}
	
	public SubscriptionCustomerInfo updateCustomerInfo(SubscriptionCustomerInfo customerInfo) {
		return customerRepository.save(customerInfo);
	}
	
	public Optional<SubscriptionCustomerInfo> getCustomerInfoByCustomerId(String customerId) {
		List<SubscriptionCustomerInfo> subscriptionCustomerInfoList;
		
		return ( !((subscriptionCustomerInfoList = customerRepository.findByCustomerId(customerId)).isEmpty()) ?  Optional.of(subscriptionCustomerInfoList.get(0)) : Optional.empty() );
	}
}
