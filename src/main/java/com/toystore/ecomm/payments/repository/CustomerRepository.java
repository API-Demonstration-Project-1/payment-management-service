package com.toystore.ecomm.payments.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toystore.ecomm.payments.model.SubscriptionCustomerInfo;

@Repository
public interface CustomerRepository extends CrudRepository<SubscriptionCustomerInfo, Integer>{
	List<SubscriptionCustomerInfo> findByCustomerId(String customerId);
}
