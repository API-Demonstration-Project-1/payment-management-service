package com.toystore.ecomm.payments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.toystore.ecomm.payments.factory.POJOFactory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * SubscriptionProductInfo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode

@Entity
@Table(name = "PTMS_SUBSCRIPTION_PRODUCT")
public class SubscriptionProductInfo {
	
	static {
		POJOFactory.register("SUBSCRIPTIONPRODUCTINFO", SubscriptionProductInfo.class);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PTMS_SUBSCRIPTION_PRODUCT_ID", nullable = false)
	private Integer subscriptionProductId;

	@Column(name = "PLAN_TYPE", nullable = false)
	private String planType;

	@Column(name = "RENEWAL_TYPE", nullable = false)
	private String renewalType;

	@Column(name = "PRODUCT_ID", nullable = false)
	private String productId;

	@Column(name = "PRICE_ID", nullable = false)
	private String priceId;
}
