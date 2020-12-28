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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode (callSuper = false)

@Entity
@Table(name = "PAYMENT")
public class PaymentInfo extends Auditable<String> {
	
  static {
	  POJOFactory.register("PAYMENTINFO", PaymentInfo.class);
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "PAYMENT_ID", nullable = false)
  private Integer paymentId;

  @Column(name = "SESSION_ID", nullable = false)
  private String paymentSessionId;

  @Column(name = "TENANT_ID", nullable = false)
  private String tenantId;

  @Column(name = "AMOUNT", nullable = false)
  private Double amount;

  @Column(name = "METHOD", nullable = false)
  private String paymentMethod;
  
  @Column(name = "MODE", nullable = false)
  private String paymentMode;

  @Column(name = "STATUS", nullable = false)
  private String status;

  @Column(name = "DESCRIPTION", nullable = false)
  private String description;
}

