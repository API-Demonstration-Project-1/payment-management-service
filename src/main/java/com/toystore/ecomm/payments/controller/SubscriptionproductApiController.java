package com.toystore.ecomm.payments.controller;

import java.io.IOException;
import java.text.ParseException;
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
import com.toystore.ecomm.payments.factory.POJOFactory;
import com.toystore.ecomm.payments.model.SubscriptionProductInfo;
import com.toystore.ecomm.payments.model.Subscriptionproduct;
import com.toystore.ecomm.payments.model.Subscriptionproductresponse;
import com.toystore.ecomm.payments.services.SubscriptionProductService;
import com.toystore.ecomm.payments.util.ResponsePreparator;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-06T13:12:16.732Z")

@Controller
public class SubscriptionproductApiController implements SubscriptionproductApi {

    private static final Logger log = LoggerFactory.getLogger(SubscriptionproductApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private SubscriptionProductService productService;

    @org.springframework.beans.factory.annotation.Autowired
    public SubscriptionproductApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Subscriptionproduct>> subscriptionproductGET() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Subscriptionproduct>>(objectMapper.readValue("[ {  \"amount\" : 0.8008281904610115,  \"planType\" : \"planType\",  \"renewalType\" : \"renewalType\",  \"currency\" : \"currency\"}, {  \"amount\" : 0.8008281904610115,  \"planType\" : \"planType\",  \"renewalType\" : \"renewalType\",  \"currency\" : \"currency\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Subscriptionproduct>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Subscriptionproduct>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> subscriptionproductPOST(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Subscriptionproduct body) throws IllegalAccessException, InstantiationException, StripeException, ParseException, JsonProcessingException {
    	log.info("subscriptionproductPOST() invoked");
    	log.debug("subscriptionproductPOST() invoked with Request body: " + body);
    	
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	
            	SubscriptionProductInfo productInfo = productService.saveSubscriptionProductInfo(body.getPlanType(), body.getRenewalType(), body.getAmount(), body.getCurrency());
            	
            	log.trace("Product Info: " + productInfo);
            	
            	String resp = ResponsePreparator.prepareSubscriptionProductResponse(productInfo.getSubscriptionProductId(), "The Product is created successfully", true, null);
            	
            	log.info("subscriptionproductPOST() exited");
            	
            	return new ResponseEntity<String>(resp, HttpStatus.CREATED);
            	
            } catch (StripeException se) {
            	log.info("subscriptionproductPOST() exited with Errors");
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
