package com.toystore.ecomm.payments.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Subscriptionproduct
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-06T13:12:16.732Z")




public class Subscriptionproduct   {
  @JsonProperty("planType")
  private String planType = null;

  @JsonProperty("renewalType")
  private String renewalType = null;

  @JsonProperty("amount")
  private Double amount = null;

  @JsonProperty("currency")
  private String currency = null;

  public Subscriptionproduct planType(String planType) {
    this.planType = planType;
    return this;
  }

  /**
   * This is the Plan type of the Subscription
   * @return planType
  **/
  @ApiModelProperty(required = true, value = "This is the Plan type of the Subscription")
  @NotNull


  public String getPlanType() {
    return planType;
  }

  public void setPlanType(String planType) {
    this.planType = planType;
  }

  public Subscriptionproduct renewalType(String renewalType) {
    this.renewalType = renewalType;
    return this;
  }

  /**
   * This is the Renewal type of the Subscription
   * @return renewalType
  **/
  @ApiModelProperty(required = true, value = "This is the Renewal type of the Subscription")
  @NotNull


  public String getRenewalType() {
    return renewalType;
  }

  public void setRenewalType(String renewalType) {
    this.renewalType = renewalType;
  }

  public Subscriptionproduct amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the Amount or Charge for the Subscription
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "This is the Amount or Charge for the Subscription")
  @NotNull


  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Subscriptionproduct currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * This is the Currency
   * @return currency
  **/
  @ApiModelProperty(required = true, value = "This is the Currency")
  @NotNull


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Subscriptionproduct subscriptionproduct = (Subscriptionproduct) o;
    return Objects.equals(this.planType, subscriptionproduct.planType) &&
        Objects.equals(this.renewalType, subscriptionproduct.renewalType) &&
        Objects.equals(this.amount, subscriptionproduct.amount) &&
        Objects.equals(this.currency, subscriptionproduct.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planType, renewalType, amount, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Subscriptionproduct {\n");
    
    sb.append("    planType: ").append(toIndentedString(planType)).append("\n");
    sb.append("    renewalType: ").append(toIndentedString(renewalType)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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

