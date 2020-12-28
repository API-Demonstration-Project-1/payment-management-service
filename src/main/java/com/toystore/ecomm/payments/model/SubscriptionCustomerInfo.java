package com.toystore.ecomm.payments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.toystore.ecomm.payments.factory.POJOFactory;
import com.toystore.ecomm.payments.model.audit.Auditable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * SubscriptionCustomerInfo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)

@Entity
@Table(name = "PTMS_SUBSCRIPTION_CUSTOMER")
public class SubscriptionCustomerInfo extends Auditable<String> {
	
	static {
		POJOFactory.register("SUBSCRIPTIONCUSTOMERINFO", SubscriptionCustomerInfo.class);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PTMS_SUBSCRIPTION_CUSTOMER_ID", nullable = false)
	private Integer subscriptionCustomerId;

	@Column(name = "CUSTOMER_ID", nullable = false)
	private String customerId;

	@Column(name = "CUSTOMER_NAME", nullable = false)
	private String customerName;
	
	@Column(name = "TXN_KEY", nullable = false)
	private String txnKey;
}
