package com.toystore.ecomm.payments.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toystore.ecomm.payments.model.SubscriptionProductInfo;

@Repository
public interface SubscriptionProductRepository extends CrudRepository<SubscriptionProductInfo, Integer>{
	
}
