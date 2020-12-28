package com.toystore.ecomm.payments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.toystore.ecomm.payments.model.SubscriptionPaymentInfo;

@Repository
public interface SubscriptionPaymentRepository extends CrudRepository<SubscriptionPaymentInfo, Integer> {
	@Query("SELECT s FROM SubscriptionPaymentInfo s WHERE s.subscriptionCustomerId = :subscriptionCustomerId AND s.subscriptionStatus IN (:subscriptionStatusList)")
	List<SubscriptionPaymentInfo> findBySubscriptionCustomerIdNStatus(@Param("subscriptionCustomerId") Integer subscriptionCustomerId, @Param("subscriptionStatusList") List<String> subscriptionStatusList);
	
}
