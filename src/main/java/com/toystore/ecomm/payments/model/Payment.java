package com.toystore.ecomm.payments.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Payment
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-06T13:12:16.732Z")




public class Payment   {
  @JsonProperty("paymentId")
  private String paymentId = null;

  @JsonProperty("paymentSessionId")
  private String paymentSessionId = null;

  @JsonProperty("tenantId")
  private String tenantId = null;

  @JsonProperty("amount")
  private Double amount = null;

  @JsonProperty("paymentMode")
  private String paymentMode = null;

  @JsonProperty("paymentMethod")
  private String paymentMethod = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("description")
  private String description = null;

  public Payment paymentId(String paymentId) {
    this.paymentId = paymentId;
    return this;
  }

  /**
   * This is the ID of the payment made
   * @return paymentId
  **/
  @ApiModelProperty(required = true, value = "This is the ID of the payment made")
  @NotNull


  public String getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }

  public Payment paymentSessionId(String paymentSessionId) {
    this.paymentSessionId = paymentSessionId;
    return this;
  }

  /**
   * This is the reference no. from Payment Gateway
   * @return paymentSessionId
  **/
  @ApiModelProperty(required = true, value = "This is the reference no. from Payment Gateway")
  @NotNull


  public String getPaymentSessionId() {
    return paymentSessionId;
  }

  public void setPaymentSessionId(String paymentSessionId) {
    this.paymentSessionId = paymentSessionId;
  }

  public Payment tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  /**
   * This is the ID of the Tenant who made payment
   * @return tenantId
  **/
  @ApiModelProperty(value = "This is the ID of the Tenant who made payment")


  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  public Payment amount(Double amount) {
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

  public Payment paymentMode(String paymentMode) {
    this.paymentMode = paymentMode;
    return this;
  }

  /**
   * This gives the payment mode (payment, subscription, setup) used.
   * @return paymentMode
  **/
  @ApiModelProperty(required = true, value = "This gives the payment mode (payment, subscription, setup) used.")
  @NotNull


  public String getPaymentMode() {
    return paymentMode;
  }

  public void setPaymentMode(String paymentMode) {
    this.paymentMode = paymentMode;
  }

  public Payment paymentMethod(String paymentMethod) {
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

  public Payment status(String status) {
    this.status = status;
    return this;
  }

  /**
   * This gives the Status of the payment
   * @return status
  **/
  @ApiModelProperty(required = true, value = "This gives the Status of the payment")
  @NotNull


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Payment description(String description) {
    this.description = description;
    return this;
  }

  /**
   * This gives the description about the payment
   * @return description
  **/
  @ApiModelProperty(value = "This gives the description about the payment")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payment payment = (Payment) o;
    return Objects.equals(this.paymentId, payment.paymentId) &&
        Objects.equals(this.paymentSessionId, payment.paymentSessionId) &&
        Objects.equals(this.tenantId, payment.tenantId) &&
        Objects.equals(this.amount, payment.amount) &&
        Objects.equals(this.paymentMode, payment.paymentMode) &&
        Objects.equals(this.paymentMethod, payment.paymentMethod) &&
        Objects.equals(this.status, payment.status) &&
        Objects.equals(this.description, payment.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentId, paymentSessionId, tenantId, amount, paymentMode, paymentMethod, status, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payment {\n");
    
    sb.append("    paymentId: ").append(toIndentedString(paymentId)).append("\n");
    sb.append("    paymentSessionId: ").append(toIndentedString(paymentSessionId)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    paymentMode: ").append(toIndentedString(paymentMode)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

