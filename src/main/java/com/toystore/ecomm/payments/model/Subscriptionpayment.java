package com.toystore.ecomm.payments.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.toystore.ecomm.payments.factory.UIModelFactory;

import io.swagger.annotations.ApiModelProperty;

/**
 * Subscriptionpayment
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-06T13:12:16.732Z")
@Component
public class Subscriptionpayment {

	static {
		UIModelFactory.register("SUBSCRIPTIONPAYMENT", Subscriptionpayment.class);
	}
	
	@JsonProperty("subscriptionCustomerId")
	private Integer subscriptionCustomerId = null;

	@JsonProperty("planType")
	private String planType = null;

	@JsonProperty("renewalType")
	private String renewalType = null;

	@JsonProperty("paymentMethod")
	private String paymentMethod = null;

	@JsonProperty("trialDays")
	private Integer trialDays = null;
	
	@JsonProperty("cardToken")
	private String cardToken = null;

	@JsonProperty("cancelAtPeriodEnd")
	private String cancelAtPeriodEnd = null;

	public Subscriptionpayment subscriptionCustomerId(Integer subscriptionCustomerId) {
		this.subscriptionCustomerId = subscriptionCustomerId;
		return this;
	}

	/**
	 * This is the ID of the Customer created
	 * 
	 * @return subscriptionCustomerId
	 **/
	@ApiModelProperty(required = true, value = "This is the ID of the Customer created")
	@NotNull
	public Integer getSubscriptionCustomerId() {
		return subscriptionCustomerId;
	}

	public void setSubscriptionCustomerId(Integer subscriptionCustomerId) {
		this.subscriptionCustomerId = subscriptionCustomerId;
	}

	public Subscriptionpayment planType(String planType) {
		this.planType = planType;
		return this;
	}

	/**
	 * This is the Subscription Plan Type
	 * 
	 * @return planType
	 **/
	@ApiModelProperty(required = true, value = "This is the Subscription Plan Type")
	@NotNull
	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public Subscriptionpayment renewalType(String renewalType) {
		this.renewalType = renewalType;
		return this;
	}

	/**
	 * This is the Subscription Renewal Type
	 * 
	 * @return renewalType
	 **/
	@ApiModelProperty(required = true, value = "This is the Subscription Renewal Type")
	@NotNull
	public String getRenewalType() {
		return renewalType;
	}

	public void setRenewalType(String renewalType) {
		this.renewalType = renewalType;
	}

	public Subscriptionpayment paymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
		return this;
	}

	/**
	 * This gives the payment method (card, upi, wallet) used.
	 * 
	 * @return paymentMethod
	 **/
	@ApiModelProperty(required = false, value = "This gives the payment method (card, upi, wallet) used.")
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Subscriptionpayment trialDays(Integer trialDays) {
		this.trialDays = trialDays;
		return this;
	}

	/**
	 * This gives the no. of trial days of the Subscription
	 * 
	 * @return trialDays
	 **/
	@ApiModelProperty(value = "This gives the no. of trial days of the Subscription")

	public Integer getTrialDays() {
		return trialDays;
	}

	public void setTrialDays(Integer trialDays) {
		this.trialDays = trialDays;
	}

	public Subscriptionpayment cancelAtPeriodEnd(String cancelAtPeriodEnd) {
		this.cancelAtPeriodEnd = cancelAtPeriodEnd;
		return this;
	}

	/**
	 * This tells whether Subscription should be cancelled as soon as it expires.
	 * 
	 * @return cancelAtPeriodEnd
	 **/
	@ApiModelProperty(value = "This tells whether Subscription should be cancelled as soon as it expires.")

	public String getCancelAtPeriodEnd() {
		return cancelAtPeriodEnd;
	}

	public void setCancelAtPeriodEnd(String cancelAtPeriodEnd) {
		this.cancelAtPeriodEnd = cancelAtPeriodEnd;
	}
	
	public Subscriptionpayment cardToken(String cardToken) {
		this.cardToken = cardToken;
		return this;
	}

	@ApiModelProperty(required = false, value = "This gives the Card Token")
	public String getCardToken() {
		return cardToken;
	}

	public void setCardToken(String cardToken) {
		this.cardToken = cardToken;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Subscriptionpayment subscriptionpayment = (Subscriptionpayment) o;
		return Objects.equals(this.subscriptionCustomerId, subscriptionpayment.subscriptionCustomerId)
				&& Objects.equals(this.planType, subscriptionpayment.planType)
				&& Objects.equals(this.renewalType, subscriptionpayment.renewalType)
				&& Objects.equals(this.paymentMethod, subscriptionpayment.paymentMethod)
				&& Objects.equals(this.trialDays, subscriptionpayment.trialDays)
				&& Objects.equals(this.cancelAtPeriodEnd, subscriptionpayment.cancelAtPeriodEnd)
				&& Objects.equals(this.cardToken, subscriptionpayment.cardToken);
	}

	@Override
	public int hashCode() {
		return Objects.hash(subscriptionCustomerId, planType, renewalType, paymentMethod, trialDays, cancelAtPeriodEnd, cardToken);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Subscriptionpayment {\n");

		sb.append("    subscriptionCustomerId: ").append(toIndentedString(subscriptionCustomerId)).append("\n");
		sb.append("    planType: ").append(toIndentedString(planType)).append("\n");
		sb.append("    renewalType: ").append(toIndentedString(renewalType)).append("\n");
		sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
		sb.append("    trialDays: ").append(toIndentedString(trialDays)).append("\n");
		sb.append("    cancelAtPeriodEnd: ").append(toIndentedString(cancelAtPeriodEnd)).append("\n");
		sb.append("    cardToken: ").append(toIndentedString(cardToken)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
