package com.toystore.ecomm.payments.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.exception.StripeException;
import com.toystore.ecomm.payments.model.Payment;
import com.toystore.ecomm.payments.model.PaymentInfo;
import com.toystore.ecomm.payments.model.Paymentresponse;
import com.toystore.ecomm.payments.services.PaymentService;
import com.toystore.ecomm.payments.util.ResponsePreparator;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-20T20:27:27.686Z")

@Controller
public class PaymentApiController implements PaymentApi {

    private static final Logger log = LoggerFactory.getLogger(PaymentApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private PaymentService paymentService;
    
    @org.springframework.beans.factory.annotation.Autowired
    public PaymentApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> paymentByPaymentIdDELETE(@ApiParam(value = "",required=true) @PathVariable("paymentId") String paymentId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Payment> paymentByPaymentIdGET(@ApiParam(value = "",required=true) @PathVariable("paymentId") String paymentId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Payment>(objectMapper.readValue("{  \"paymentIntentId\" : \"paymentIntentId\",  \"amount\" : 0.8008281904610115,  \"paymentId\" : \"paymentId\",  \"tenantId\" : \"tenantId\",  \"paymentMethod\" : \"paymentMethod\",  \"description\" : \"description\",  \"status\" : \"status\"}", Payment.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Payment>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Paymentresponse> paymentByPaymentIdPOST(@ApiParam(value = "",required=true) @PathVariable("paymentId") String paymentId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Payment body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Paymentresponse>(objectMapper.readValue("{  \"success\" : true,  \"message\" : \"The Payment has been created successfully\",  \"data\" : {    \"id\" : 123  },  \"error_code\" : 400}", Paymentresponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Paymentresponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Paymentresponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Payment> paymentByPaymentIdPUT(@ApiParam(value = "",required=true) @PathVariable("paymentId") String paymentId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Payment body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Payment>(objectMapper.readValue("{  \"paymentIntentId\" : \"paymentIntentId\",  \"amount\" : 0.8008281904610115,  \"paymentId\" : \"paymentId\",  \"tenantId\" : \"tenantId\",  \"paymentMethod\" : \"paymentMethod\",  \"description\" : \"description\",  \"status\" : \"status\"}", Payment.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Payment>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Payment>> paymentGET(@ApiParam(value = "Get payment info for a given Tenant Name") @Valid @RequestParam(value = "tenantName", required = false) String tenantName,@ApiParam(value = "Get all payment info based on payment status") @Valid @RequestParam(value = "paymentStatus", required = false) String paymentStatus,@ApiParam(value = "Get all payment info based on payment method") @Valid @RequestParam(value = "paymentMethod", required = false) String paymentMethod) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Payment>>(objectMapper.readValue("[ {  \"paymentIntentId\" : \"paymentIntentId\",  \"amount\" : 0.8008281904610115,  \"paymentId\" : \"paymentId\",  \"tenantId\" : \"tenantId\",  \"paymentMethod\" : \"paymentMethod\",  \"description\" : \"description\",  \"status\" : \"status\"}, {  \"paymentIntentId\" : \"paymentIntentId\",  \"amount\" : 0.8008281904610115,  \"paymentId\" : \"paymentId\",  \"tenantId\" : \"tenantId\",  \"paymentMethod\" : \"paymentMethod\",  \"description\" : \"description\",  \"status\" : \"status\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Payment>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Payment>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> paymentPOST(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Payment body) throws IllegalAccessException, InstantiationException {
    	log.info("paymentPOST() invoked");
    	log.debug("paymentPOST() invoked with Request body: " + body);
    	
    	String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	PaymentInfo paymentInfo = new PaymentInfo();
            	paymentInfo.setPaymentMode(body.getPaymentMode());
            	paymentInfo.setPaymentMethod(body.getPaymentMethod());
            	paymentInfo.setAmount(body.getAmount());
            	paymentInfo.setTenantId(body.getTenantId());
            	
            	paymentService.savePaymentInfo(paymentInfo);
            	
            	log.trace("Payment Info: " + paymentInfo);
            	
            	String resp = ResponsePreparator.preparePaymentResponse(paymentInfo.getPaymentId(), "The Payment is done successfully", true, null);
            	
            	log.info("paymentPOST() exited");
            	
            	return new ResponseEntity<String>(resp, HttpStatus.CREATED);
            } catch (StripeException se) {
            	log.info("paymentPOST() exited with Errors");
            	log.error("Error in the Payment Gateway", se);
            	
            	String resp = ResponsePreparator.preparePaymentResponse(null, "Payment Gateway Error - " + se.getMessage(), false, -1);
            	
                return new ResponseEntity<String>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (Exception e) {
            	log.info("paymentPOST() exited with Errors");
                log.error("Couldn't serialize response for content type application/json", e);
                
                String resp = ResponsePreparator.preparePaymentResponse(null, "Server Error - " + e.getMessage(), false, -1);
                
                return new ResponseEntity<String>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        log.info("paymentPOST() exited");
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }

}
