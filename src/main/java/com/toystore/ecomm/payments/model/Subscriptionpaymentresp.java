package com.toystore.ecomm.payments.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Subscriptionpaymentresp
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-30T00:47:07.962Z")




public class Subscriptionpaymentresp   {
  @JsonProperty("subscriptionPaymentId")
  private Integer subscriptionPaymentId = null;

  @JsonProperty("subscriptionId")
  private String subscriptionId = null;

  @JsonProperty("subscriptionStatus")
  private String subscriptionStatus = null;

  @JsonProperty("amount")
  private Double amount = null;

  @JsonProperty("paymentMethod")
  private String paymentMethod = null;

  @JsonProperty("invoiceStatus")
  private String invoiceStatus = null;

  @JsonProperty("paymentIntentStatus")
  private String paymentIntentStatus = null;

  @JsonProperty("customerId")
  private String customerId = null;

  @JsonProperty("invoiceId")
  private String invoiceId = null;

  @JsonProperty("paymentIntentId")
  private String paymentIntentId = null;

  @JsonProperty("subscriptionStart")
  private String subscriptionStart = null;

  @JsonProperty("subscriptionEnd")
  private String subscriptionEnd = null;

  @JsonProperty("trialStart")
  private String trialStart = null;

  @JsonProperty("trialEnd")
  private String trialEnd = null;

  @JsonProperty("cancelAtPeriodEnd")
  private String cancelAtPeriodEnd = null;

  public Subscriptionpaymentresp subscriptionPaymentId(Integer subscriptionPaymentId) {
    this.subscriptionPaymentId = subscriptionPaymentId;
    return this;
  }

  /**
   * This is the ID of the payment made for Subscription
   * @return subscriptionPaymentId
  **/
  @ApiModelProperty(required = true, value = "This is the ID of the payment made for Subscription")
  @NotNull


  public Integer getSubscriptionPaymentId() {
    return subscriptionPaymentId;
  }

  public void setSubscriptionPaymentId(Integer subscriptionPaymentId) {
    this.subscriptionPaymentId = subscriptionPaymentId;
  }

  public Subscriptionpaymentresp subscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

  /**
   * This is the reference no. for created Subscription from Payment Gateway
   * @return subscriptionId
  **/
  @ApiModelProperty(required = true, value = "This is the reference no. for created Subscription from Payment Gateway")
  @NotNull


  public String getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public Subscriptionpaymentresp subscriptionStatus(String subscriptionStatus) {
    this.subscriptionStatus = subscriptionStatus;
    return this;
  }

  /**
   * This is the Status of the created Subscription from Payment Gateway
   * @return subscriptionStatus
  **/
  @ApiModelProperty(value = "This is the Status of the created Subscription from Payment Gateway")


  public String getSubscriptionStatus() {
    return subscriptionStatus;
  }

  public void setSubscriptionStatus(String subscriptionStatus) {
    this.subscriptionStatus = subscriptionStatus;
  }

  public Subscriptionpaymentresp amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount value
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "This is the amount value")
  @NotNull


  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Subscriptionpaymentresp paymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

  /**
   * This gives the payment method (card, upi, wallet) used.
   * @return paymentMethod
  **/
  @ApiModelProperty(required = true, value = "This gives the payment method (card, upi, wallet) used.")
  @NotNull


  public String getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public Subscriptionpaymentresp invoiceStatus(String invoiceStatus) {
    this.invoiceStatus = invoiceStatus;
    return this;
  }

  /**
   * This gives the Status of the created Invoice from Payment Gateway
   * @return invoiceStatus
  **/
  @ApiModelProperty(required = true, value = "This gives the Status of the created Invoice from Payment Gateway")
  @NotNull


  public String getInvoiceStatus() {
    return invoiceStatus;
  }

  public void setInvoiceStatus(String invoiceStatus) {
    this.invoiceStatus = invoiceStatus;
  }

  public Subscriptionpaymentresp paymentIntentStatus(String paymentIntentStatus) {
    this.paymentIntentStatus = paymentIntentStatus;
    return this;
  }

  /**
   * This gives the Status of the created PaymentIntent from Payment Gateway
   * @return paymentIntentStatus
  **/
  @ApiModelProperty(required = true, value = "This gives the Status of the created PaymentIntent from Payment Gateway")
  @NotNull


  public String getPaymentIntentStatus() {
    return paymentIntentStatus;
  }

  public void setPaymentIntentStatus(String paymentIntentStatus) {
    this.paymentIntentStatus = paymentIntentStatus;
  }

  public Subscriptionpaymentresp customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * This is the ID of the Customer created in Payment Gateway
   * @return customerId
  **/
  @ApiModelProperty(required = true, value = "This is the ID of the Customer created in Payment Gateway")
  @NotNull


  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public Subscriptionpaymentresp invoiceId(String invoiceId) {
    this.invoiceId = invoiceId;
    return this;
  }

  /**
   * This is the ID of the created Invoice from Payment Gateway
   * @return invoiceId
  **/
  @ApiModelProperty(required = true, value = "This is the ID of the created Invoice from Payment Gateway")
  @NotNull


  public String getInvoiceId() {
    return invoiceId;
  }

  public void setInvoiceId(String invoiceId) {
    this.invoiceId = invoiceId;
  }

  public Subscriptionpaymentresp paymentIntentId(String paymentIntentId) {
    this.paymentIntentId = paymentIntentId;
    return this;
  }

  /**
   * This is the ID of the created PaymentIntent from Payment Gateway
   * @return paymentIntentId
  **/
  @ApiModelProperty(required = true, value = "This is the ID of the created PaymentIntent from Payment Gateway")
  @NotNull


  public String getPaymentIntentId() {
    return paymentIntentId;
  }

  public void setPaymentIntentId(String paymentIntentId) {
    this.paymentIntentId = paymentIntentId;
  }

  public Subscriptionpaymentresp subscriptionStart(String subscriptionStart) {
    this.subscriptionStart = subscriptionStart;
    return this;
  }

  /**
   * This is the Subscription Start Timestamp
   * @return subscriptionStart
  **/
  @ApiModelProperty(required = true, value = "This is the Subscription Start Timestamp")


  public String getSubscriptionStart() {
    return subscriptionStart;
  }

  public void setSubscriptionStart(String subscriptionStart) {
    this.subscriptionStart = subscriptionStart;
  }

  public Subscriptionpaymentresp subscriptionEnd(String subscriptionEnd) {
    this.subscriptionEnd = subscriptionEnd;
    return this;
  }

  /**
   * This is the Subscription End Timestamp
   * @return subscriptionEnd
  **/
  @ApiModelProperty(required = true, value = "This is the Subscription End Timestamp")


  public String getSubscriptionEnd() {
    return subscriptionEnd;
  }

  public void setSubscriptionEnd(String subscriptionEnd) {
    this.subscriptionEnd = subscriptionEnd;
  }

  public Subscriptionpaymentresp trialStart(String trialStart) {
    this.trialStart = trialStart;
    return this;
  }

  /**
   * This is the Trial (if any) Start Timestamp
   * @return trialStart
  **/
  @ApiModelProperty(required = true, value = "This is the Trial (if any) Start Timestamp")

  public String getTrialStart() {
    return trialStart;
  }

  public void setTrialStart(String trialStart) {
    this.trialStart = trialStart;
  }

  public Subscriptionpaymentresp trialEnd(String trialEnd) {
    this.trialEnd = trialEnd;
    return this;
  }

  /**
   * This is the Trial (if any) End Timestamp
   * @return trialEnd
  **/
  @ApiModelProperty(required = true, value = "This is the Trial (if any) End Timestamp")

  public String getTrialEnd() {
    return trialEnd;
  }

  public void setTrialEnd(String trialEnd) {
    this.trialEnd = trialEnd;
  }

 

public Subscriptionpaymentresp cancelAtPeriodEnd(String cancelAtPeriodEnd) {
    this.cancelAtPeriodEnd = cancelAtPeriodEnd;
    return this;
  }


@ApiModelProperty(required = true, value = "This tells whether Subscription should be cancelled as soon as it expires")
@NotNull
public String getCancelAtPeriodEnd() {
	return cancelAtPeriodEnd;
}

public void setCancelAtPeriodEnd(String cancelAtPeriodEnd) {
	this.cancelAtPeriodEnd = cancelAtPeriodEnd;
}


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Subscriptionpaymentresp subscriptionpayment = (Subscriptionpaymentresp) o;
    return Objects.equals(this.subscriptionPaymentId, subscriptionpayment.subscriptionPaymentId) &&
        Objects.equals(this.subscriptionId, subscriptionpayment.subscriptionId) &&
        Objects.equals(this.subscriptionStatus, subscriptionpayment.subscriptionStatus) &&
        Objects.equals(this.amount, subscriptionpayment.amount) &&
        Objects.equals(this.paymentMethod, subscriptionpayment.paymentMethod) &&
        Objects.equals(this.invoiceStatus, subscriptionpayment.invoiceStatus) &&
        Objects.equals(this.paymentIntentStatus, subscriptionpayment.paymentIntentStatus) &&
        Objects.equals(this.customerId, subscriptionpayment.customerId) &&
        Objects.equals(this.invoiceId, subscriptionpayment.invoiceId) &&
        Objects.equals(this.paymentIntentId, subscriptionpayment.paymentIntentId) &&
        Objects.equals(this.subscriptionStart, subscriptionpayment.subscriptionStart) &&
        Objects.equals(this.subscriptionEnd, subscriptionpayment.subscriptionEnd) &&
        Objects.equals(this.trialStart, subscriptionpayment.trialStart) &&
        Objects.equals(this.trialEnd, subscriptionpayment.trialEnd) &&
        Objects.equals(this.cancelAtPeriodEnd, subscriptionpayment.cancelAtPeriodEnd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subscriptionPaymentId, subscriptionId, subscriptionStatus, amount, paymentMethod, invoiceStatus, paymentIntentStatus, customerId, invoiceId, paymentIntentId, subscriptionStart, subscriptionEnd, trialStart, trialEnd, cancelAtPeriodEnd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Subscriptionpayment {\n");
    
    sb.append("    subscriptionPaymentId: ").append(toIndentedString(subscriptionPaymentId)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    subscriptionStatus: ").append(toIndentedString(subscriptionStatus)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    invoiceStatus: ").append(toIndentedString(invoiceStatus)).append("\n");
    sb.append("    paymentIntentStatus: ").append(toIndentedString(paymentIntentStatus)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    invoiceId: ").append(toIndentedString(invoiceId)).append("\n");
    sb.append("    paymentIntentId: ").append(toIndentedString(paymentIntentId)).append("\n");
    sb.append("    subscriptionStart: ").append(toIndentedString(subscriptionStart)).append("\n");
    sb.append("    subscriptionEnd: ").append(toIndentedString(subscriptionEnd)).append("\n");
    sb.append("    trialStart: ").append(toIndentedString(trialStart)).append("\n");
    sb.append("    trialEnd: ").append(toIndentedString(trialEnd)).append("\n");
    sb.append("    description: ").append(toIndentedString(cancelAtPeriodEnd)).append("\n");
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

