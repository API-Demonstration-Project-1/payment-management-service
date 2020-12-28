package com.toystore.ecomm.payments.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Subscriptioncustomer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-06T13:12:16.732Z")




public class Subscriptioncustomer   {
  @JsonProperty("subscriptionCustomerId")
  private Integer subscriptionCustomerId = null;

  @JsonProperty("customerId")
  private String customerId = null;

  @JsonProperty("customerName")
  private String customerName = null;

  public Subscriptioncustomer subscriptionCustomerId(Integer subscriptionCustomerId) {
    this.subscriptionCustomerId = subscriptionCustomerId;
    return this;
  }

  /**
   * This is the ID of the Subscription Customer
   * @return subscriptionCustomerId
  **/
  @ApiModelProperty(required = false, value = "This is the ID of the Subscription Customer")
  public Integer getSubscriptionCustomerId() {
    return subscriptionCustomerId;
  }

  public void setSubscriptionCustomerId(Integer subscriptionCustomerId) {
    this.subscriptionCustomerId = subscriptionCustomerId;
  }

  public Subscriptioncustomer customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * This is the Customer Reference ID from Stripe Payment Gateway
   * @return customerId
  **/
  @ApiModelProperty(required = false, value = "This is the Customer Reference ID from Stripe Payment Gateway")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public Subscriptioncustomer customerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  /**
   * This is the name of the Customer
   * @return customerName
  **/
  @ApiModelProperty(required = true, value = "This is the name of the Customer")
  @NotNull
  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Subscriptioncustomer subscriptioncustomer = (Subscriptioncustomer) o;
    return Objects.equals(this.subscriptionCustomerId, subscriptioncustomer.subscriptionCustomerId) &&
        Objects.equals(this.customerId, subscriptioncustomer.customerId) &&
        Objects.equals(this.customerName, subscriptioncustomer.customerName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subscriptionCustomerId, customerId, customerName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Subscriptioncustomer {\n");
    
    sb.append("    subscriptionCustomerId: ").append(toIndentedString(subscriptionCustomerId)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
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

