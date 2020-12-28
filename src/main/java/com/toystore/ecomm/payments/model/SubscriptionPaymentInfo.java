package com.toystore.ecomm.payments.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.toystore.ecomm.payments.factory.POJOFactory;
import com.toystore.ecomm.payments.model.audit.Auditable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode (callSuper = false)

@Entity
@Table(name = "SUBSCRIPTION_PAYMENT")
@EntityListeners(AuditingEntityListener.class)
public class SubscriptionPaymentInfo extends Auditable<String> {
	
	static {
		POJOFactory.register("SUBSCRIPTIONPAYMENTINFO", SubscriptionPaymentInfo.class);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SUBSCRIPTION_PAYMENT_ID", nullable = false)
	private Integer subscriptionPaymentId;

	@Column(name = "SUBSCRIPTION_ID", nullable = false)
	private String subscriptionId;

	@Column(name = "SUBSCRIPTION_STATUS", nullable = false)
	private String subscriptionStatus;

	@Column(name = "AMOUNT", nullable = false)
	private Double amount;

	@Column(name = "METHOD", nullable = false)
	private String paymentMethod;

	@Column(name = "INVOICE_STATUS", nullable = false)
	private String invoiceStatus;

	@Column(name = "PAYMENTINTENT_STATUS", nullable = false)
	private String paymentIntentStatus;

	@Column(name = "SUBSCRIPTION_CUSTOMER_ID", nullable = false)
	private Integer subscriptionCustomerId;
	
	@Column(name = "SUBSCRIPTION_PRODUCT_ID", nullable = false)
	private Integer subscriptionProductId;

	@Column(name = "INVOICE_ID", nullable = false)
	private String invoiceId;

	@Column(name = "PAYMENTINTENT_ID", nullable = false)
	private String paymentIntentId;

	@Column(name = "PERIOD_START")
	private Date subscriptionStart;

	@Column(name = "PERIOD_END")
	private Date subscriptionEnd;

	@Column(name = "TRIAL_START")
	private Date trialStart;

	@Column(name = "TRIAL_END")
	private Date trialEnd;

	@Column(name = "CANCEL_AT_PERIOD_END", nullable = false)
	private String cancelAtPeriodEnd;
	
	@OneToOne
	@JoinColumn(name = "SUBSCRIPTION_CUSTOMER_ID", referencedColumnName = "PTMS_SUBSCRIPTION_CUSTOMER_ID", nullable = false, insertable = false, updatable = false)
	private SubscriptionCustomerInfo subscriptionCustomerInfo;
	
	@OneToOne
	@JoinColumn(name = "SUBSCRIPTION_PRODUCT_ID", referencedColumnName = "PTMS_SUBSCRIPTION_PRODUCT_ID", nullable = false, insertable = false, updatable = false)
	private SubscriptionProductInfo subscriptionProductInfo;
}
