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
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.exception.StripeException;
import com.toystore.ecomm.payments.model.SubscriptionCustomerInfo;
import com.toystore.ecomm.payments.model.Subscriptioncustomer;
import com.toystore.ecomm.payments.services.CustomerService;
import com.toystore.ecomm.payments.util.ResponsePreparator;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-06T13:12:16.732Z")

@Controller
public class SubscriptioncustomerApiController implements SubscriptioncustomerApi {

    private static final Logger log = LoggerFactory.getLogger(SubscriptioncustomerApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private CustomerService customerService;

    @org.springframework.beans.factory.annotation.Autowired
    public SubscriptioncustomerApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Subscriptioncustomer>> subscriptioncustomerGET() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Subscriptioncustomer>>(objectMapper.readValue("[ {  \"subscriptionCustomerId\" : 0,  \"customerId\" : \"customerId\",  \"customerName\" : \"customerName\"}, {  \"subscriptionCustomerId\" : 0,  \"customerId\" : \"customerId\",  \"customerName\" : \"customerName\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Subscriptioncustomer>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Subscriptioncustomer>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> subscriptioncustomerPOST(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Subscriptioncustomer body) throws IllegalAccessException, InstantiationException, StripeException, JsonProcessingException {
    	log.info("subscriptioncustomerPOST() invoked");
    	log.debug("subscriptioncustomerPOST() invoked with Request body: " + body);
    	
    	String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	
            	SubscriptionCustomerInfo customerInfo = customerService.saveCustomerInfo(body.getCustomerName());
            	
            	log.trace("Customer Info: " + customerInfo);
            	
            	String resp = ResponsePreparator.prepareSubscriptionCustomerResponse(customerInfo.getSubscriptionCustomerId(), "The Customer is created successfully", true, null);
            	
            	log.info("subscriptioncustomerPOST() exited");
            	
            	return new ResponseEntity<String>(resp, HttpStatus.CREATED);
            	
            } catch (StripeException se) {
            	log.info("subscriptioncustomerPOST() exited with Errors");
            	log.error("Error in the Payment Gateway", se);
            	
            	String resp = ResponsePreparator.prepareSubscriptionPaymentResponse(null, "Payment Gateway Error - " + se.getMessage(), false, -1);
            	
                return new ResponseEntity<String>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

}
