package com.toystore.ecomm.payments.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.PriceCreateParams.Recurring;
import com.stripe.param.PriceCreateParams.Recurring.Interval;
import com.stripe.param.PriceCreateParams.Recurring.UsageType;
import com.stripe.param.ProductCreateParams;
import com.stripe.param.ProductCreateParams.Type;
import com.toystore.ecomm.payments.constants.PPMSConstants;
import com.toystore.ecomm.payments.factory.POJOFactory;
import com.toystore.ecomm.payments.model.SubscriptionProductInfo;
import com.toystore.ecomm.payments.repository.SubscriptionProductRepository;

@Service
public class SubscriptionProductService {

	@Autowired
	private SubscriptionProductRepository productRepository;

	public SubscriptionProductInfo saveSubscriptionProductInfo (String planType, String renewalType, Double amount, String currency) throws StripeException, ParseException, IllegalAccessException, InstantiationException {
		  Stripe.apiKey = "sk_test_51HOi5SGpfnkrm8HZQY5SsL5g62yJAUaXhtnu1bk1pjNgL9uzticGidhfCMFUSR9WkbZNhAlOGJcPA4UQGefwE89s00g0oKuGxn";
	
			
		  // First CREATE THE PRODUCT
		  ProductCreateParams productParams = ProductCreateParams.builder()
				  							  .setName(planType.concat(renewalType)) 
				  							  .setType(Type.SERVICE).build();
		  
		  Product product = Product.create(productParams);
		  
		  // Then CREATE THE PRICE
		  Recurring recurring = null;
		  switch (renewalType) {
			case PPMSConstants.SUBS_MONTHLY: recurring = Recurring.builder().setInterval(Interval.MONTH).setUsageType(UsageType.LICENSED).build(); break;
			case PPMSConstants.SUBS_QUATERLY: recurring = Recurring.builder().setInterval(Interval.MONTH).setIntervalCount(3L).setUsageType(UsageType.LICENSED).build(); break;
			case PPMSConstants.SUBS_HALFYEARLY: recurring = Recurring.builder().setInterval(Interval.MONTH).setIntervalCount(6L).setUsageType(UsageType.LICENSED).build(); break;
			case PPMSConstants.SUBS_YEARLY: recurring = Recurring.builder().setInterval(Interval.YEAR).setUsageType(UsageType.LICENSED).build(); break;
		  }
		  
		  PriceCreateParams priceParams = PriceCreateParams.builder() 
				  				         .setProduct(product.getId())
				  				         .setUnitAmountDecimal(new BigDecimal(amount))
				  				         .setCurrency(currency)
				  				         .setRecurring(recurring)
				  				         .build();
		  
		  Price price = Price.create(priceParams);
		 
		  SubscriptionProductInfo subscriptionProductInfo = (SubscriptionProductInfo)POJOFactory.getInstance("SUBSCRIPTIONPRODUCTINFO");
		  
		  subscriptionProductInfo.setPlanType(planType);
		  subscriptionProductInfo.setRenewalType(renewalType);
		  subscriptionProductInfo.setProductId(product.getId());
		  subscriptionProductInfo.setPriceId(price.getId());
		  
		  return productRepository.save(subscriptionProductInfo);
	}
	
	@CachePut("subscriptionProducts")
	public List<SubscriptionProductInfo> getAllSubscriptionProductInfo() {
		List<SubscriptionProductInfo> subscriptionProductInfoList = new ArrayList<SubscriptionProductInfo>();
		
		productRepository.findAll().forEach(subscriptionProductInfoList::add);
		
		return subscriptionProductInfoList;
	}
}
