package com.toystore.ecomm.payments.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.ListIterator;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Event;
import com.stripe.model.EventDataObjectDeserializer;
import com.stripe.model.StripeObject;
import com.stripe.model.Subscription;
import com.stripe.net.Webhook;
import com.toystore.ecomm.payments.model.Message;
import com.toystore.ecomm.payments.model.SubscriptionPaymentInfo;
import com.toystore.ecomm.payments.model.Subscriptionpayment;
import com.toystore.ecomm.payments.services.SubscriptionPaymentService;
import com.toystore.ecomm.payments.util.ResponsePreparator;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-30T00:47:07.962Z")

@Controller
public class SubscriptionpaymentApiController implements SubscriptionpaymentApi {

    private static final Logger log = LoggerFactory.getLogger(SubscriptionpaymentApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private SubscriptionPaymentService paymentService;

    @org.springframework.beans.factory.annotation.Autowired
    public SubscriptionpaymentApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Subscriptionpayment> getSubscriptionpaymentGET(@ApiParam(value = "",required=true) @PathVariable("subscriptionPaymentId") String subscriptionPaymentId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Subscriptionpayment>(objectMapper.readValue("{  \"paymentIntentId\" : \"paymentIntentId\",  \"trialEnd\" : \"trialEnd\",  \"amount\" : 6.027456183070403,  \"trialStart\" : \"trialStart\",  \"description\" : \"description\",  \"subscriptionEnd\" : \"subscriptionEnd\",  \"subscriptionStatus\" : \"subscriptionStatus\",  \"customerId\" : \"customerId\",  \"subscriptionStart\" : \"subscriptionStart\",  \"paymentMethod\" : \"paymentMethod\",  \"paymentIntentStatus\" : \"paymentIntentStatus\",  \"invoiceId\" : \"invoiceId\",  \"subscriptionId\" : \"subscriptionId\",  \"invoiceStatus\" : \"invoiceStatus\",  \"subscriptionPaymentId\" : 0}", Subscriptionpayment.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Subscriptionpayment>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Subscriptionpayment>(HttpStatus.NOT_IMPLEMENTED);
    }
    
    // NOT USED
	/*
	 * public ResponseEntity<Subscriptionpaymentresponse>
	 * postSubscriptionpaymentPOST(@ApiParam(value =
	 * "",required=true) @PathVariable("subscriptionPaymentId") String
	 * subscriptionPaymentId,@ApiParam(value = "" ,required=true
	 * ) @Valid @RequestBody Subscriptionpayment body) { String accept =
	 * request.getHeader("Accept"); if (accept != null &&
	 * accept.contains("application/json")) { try { return new
	 * ResponseEntity<Subscriptionpaymentresponse>(objectMapper.
	 * readValue("{  \"success\" : true,  \"message\" : \"The Subscriptionpayment has been created successfully\",  \"data\" : {    \"id\" : 123  },  \"error_code\" : 400}"
	 * , Subscriptionpaymentresponse.class), HttpStatus.NOT_IMPLEMENTED); } catch
	 * (IOException e) {
	 * log.error("Couldn't serialize response for content type application/json",
	 * e); return new
	 * ResponseEntity<Subscriptionpaymentresponse>(HttpStatus.INTERNAL_SERVER_ERROR)
	 * ; } }
	 * 
	 * return new
	 * ResponseEntity<Subscriptionpaymentresponse>(HttpStatus.NOT_IMPLEMENTED); }
	 */

    public ResponseEntity<Void> subscriptionpaymentDELETE(@ApiParam(value = "",required=true) @PathVariable("subscriptionPaymentId") String subscriptionPaymentId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Subscriptionpayment>> subscriptionpaymentGET() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Subscriptionpayment>>(objectMapper.readValue("[ {  \"paymentIntentId\" : \"paymentIntentId\",  \"trialEnd\" : \"trialEnd\",  \"amount\" : 6.027456183070403,  \"trialStart\" : \"trialStart\",  \"description\" : \"description\",  \"subscriptionEnd\" : \"subscriptionEnd\",  \"subscriptionStatus\" : \"subscriptionStatus\",  \"customerId\" : \"customerId\",  \"subscriptionStart\" : \"subscriptionStart\",  \"paymentMethod\" : \"paymentMethod\",  \"paymentIntentStatus\" : \"paymentIntentStatus\",  \"invoiceId\" : \"invoiceId\",  \"subscriptionId\" : \"subscriptionId\",  \"invoiceStatus\" : \"invoiceStatus\",  \"subscriptionPaymentId\" : 0}, {  \"paymentIntentId\" : \"paymentIntentId\",  \"trialEnd\" : \"trialEnd\",  \"amount\" : 6.027456183070403,  \"trialStart\" : \"trialStart\",  \"description\" : \"description\",  \"subscriptionEnd\" : \"subscriptionEnd\",  \"subscriptionStatus\" : \"subscriptionStatus\",  \"customerId\" : \"customerId\",  \"subscriptionStart\" : \"subscriptionStart\",  \"paymentMethod\" : \"paymentMethod\",  \"paymentIntentStatus\" : \"paymentIntentStatus\",  \"invoiceId\" : \"invoiceId\",  \"subscriptionId\" : \"subscriptionId\",  \"invoiceStatus\" : \"invoiceStatus\",  \"subscriptionPaymentId\" : 0} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Subscriptionpayment>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Subscriptionpayment>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<?> subscriptionpaymentPOST(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Subscriptionpayment body) {
    	log.info("subscriptionpaymentPOST() invoked");
    	log.debug("subscriptionpaymentPOST() invoked with Request body: " + body);
    	
    	String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	
            	SubscriptionPaymentInfo paymentInfo = paymentService.saveSubscriptionPaymentInfo(body.getSubscriptionCustomerId(), body.getPlanType(), body.getRenewalType(), body.getTrialDays(), body.getPaymentMethod(), body.getCardToken(), body.getCancelAtPeriodEnd());
            	
            	log.trace("Payment Info: " + paymentInfo);
            	
            	String resp = ResponsePreparator.prepareSubscriptionPaymentResponse(paymentInfo, "The Payment for Subscription is done successfully", true, null);
            	
            	log.info("subscriptionpaymentPOST() exited");
            	
            	return new ResponseEntity<String>(resp, HttpStatus.CREATED);
            	
            } catch (ParseException pe) {
            	log.info("subscriptionpaymentPOST() exited with Errors");
            	log.error("Error while formatting Date", pe);
            	
            	try {
            		String resp = ResponsePreparator.prepareSubscriptionPaymentResponse(null, "Error while formatting Date - " + pe.getMessage(), false, -1);
            		
            		return new ResponseEntity<String>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
            	} catch (JsonProcessingException jpe1) {
            		log.info("subscriptionpaymentPOST() exited with Errors");
                	log.error("Error while processing Error JSON Response - ParseException ", jpe1);
                	
                	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            	} catch (InstantiationException ie1) {
            		log.info("subscriptionpaymentPOST() exited with Errors");
                	log.error("Error while creating an instance using Factory Pattern - ParseException", ie1);
                	
                	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            	} catch (IllegalAccessException iae1) {
            		log.info("subscriptionpaymentPOST() exited with Errors");
                	log.error("Error while creating an instance using Factory Pattern - ParseException", iae1);
                	
                	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            	}
            } catch (StripeException se) {
            	log.info("subscriptionpaymentPOST() exited with Errors");
            	log.error("Error in the Payment Gateway", se);
            	
            	try {
            		String resp = ResponsePreparator.prepareSubscriptionPaymentResponse(null, "Payment Gateway Error - " + se.getMessage(), false, -1);
            		
            		return new ResponseEntity<String>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
            	} catch (JsonProcessingException jpe1) {
            		log.info("subscriptionpaymentPOST() exited with Errors");
                	log.error("Error while processing Error JSON Response - StripeException ", jpe1);
                	
                	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            	} catch (InstantiationException ie1) {
            		log.info("subscriptionpaymentPOST() exited with Errors");
                	log.error("Error while creating an instance using Factory Pattern - StripeException", ie1);
                	
                	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            	} catch (IllegalAccessException iae1) {
            		log.info("subscriptionpaymentPOST() exited with Errors");
                	log.error("Error while creating an instance using Factory Pattern - StripeException", iae1);
                	
                	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            	}
            } catch (JsonProcessingException jpe) {
            	log.info("subscriptionpaymentPOST() exited with Errors");
            	log.error("Error while processing JSON Response", jpe);
            	
            	try {
            		String resp = ResponsePreparator.prepareSubscriptionPaymentResponse(null, "Error while processing JSON Response - " + jpe.getMessage(), false, -1);
            		
            		return new ResponseEntity<String>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
            	} catch (JsonProcessingException jpe1) {
            		log.info("subscriptionpaymentPOST() exited with Errors");
                	log.error("Error while processing Error JSON Response - JsonProcessingException ", jpe1);
                	
                	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            	} catch (InstantiationException ie1) {
            		log.info("subscriptionpaymentPOST() exited with Errors");
                	log.error("Error while creating an instance using Factory Pattern - JsonProcessingException", ie1);
                	
                	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            	} catch (IllegalAccessException iae1) {
            		log.info("subscriptionpaymentPOST() exited with Errors");
                	log.error("Error while creating an instance using Factory Pattern - JsonProcessingException", iae1);
                	
                	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            	}
            } catch (IllegalAccessException iae) {
            	log.info("subscriptionpaymentPOST() exited with Errors");
            	log.error("Error while creating an instance using Factory Pattern", iae);
            	
            	try {
            		String resp = ResponsePreparator.prepareSubscriptionPaymentResponse(null, "Error while creating a instance using Factory Pattern - " + iae.getMessage(), false, -1);
            		
            		return new ResponseEntity<String>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
            	} catch (JsonProcessingException jpe1) {
            		log.info("subscriptionpaymentPOST() exited with Errors");
                	log.error("Error while processing Error JSON Response - IllegalAccessException", jpe1);
                	
                	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            	} catch (InstantiationException ie1) {
            		log.info("subscriptionpaymentPOST() exited with Errors");
                	log.error("Error while creating an instance using Factory Pattern - IllegalAccessException", ie1);
                	
                	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            	} catch (IllegalAccessException iae1) {
            		log.info("subscriptionpaymentPOST() exited with Errors");
                	log.error("Error while creating an instance using Factory Pattern - IllegalAccessException", iae1);
                	
                	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            	}
            } catch (InstantiationException ie) {
            	log.info("subscriptionpaymentPOST() exited with Errors");
            	log.error("Error while creating an instance using Factory Pattern", ie);
            	
            	try {
            		String resp = ResponsePreparator.prepareSubscriptionPaymentResponse(null, "Error while creating a instance using Factory Pattern - " + ie.getMessage(), false, -1);
            		
            		return new ResponseEntity<String>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
            	} catch (JsonProcessingException jpe1) {
            		log.info("subscriptionpaymentPOST() exited with Errors");
                	log.error("Error while processing Error JSON Response - InstantiationException", jpe1);
                	
                	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            	} catch (InstantiationException ie1) {
            		log.info("subscriptionpaymentPOST() exited with Errors");
                	log.error("Error while creating an instance using Factory Pattern - InstantiationException", ie1);
                	
                	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            	} catch (IllegalAccessException iae1) {
            		log.info("subscriptionpaymentPOST() exited with Errors");
                	log.error("Error while creating an instance using Factory Pattern - InstantiationException", iae1);
                	
                	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            	}
            }
        }

        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Subscriptionpayment> subscriptionpaymentPUT(@ApiParam(value = "",required=true) @PathVariable("subscriptionPaymentId") String subscriptionPaymentId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Subscriptionpayment body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Subscriptionpayment>(objectMapper.readValue("{  \"paymentIntentId\" : \"paymentIntentId\",  \"trialEnd\" : \"trialEnd\",  \"amount\" : 6.027456183070403,  \"trialStart\" : \"trialStart\",  \"description\" : \"description\",  \"subscriptionEnd\" : \"subscriptionEnd\",  \"subscriptionStatus\" : \"subscriptionStatus\",  \"customerId\" : \"customerId\",  \"subscriptionStart\" : \"subscriptionStart\",  \"paymentMethod\" : \"paymentMethod\",  \"paymentIntentStatus\" : \"paymentIntentStatus\",  \"invoiceId\" : \"invoiceId\",  \"subscriptionId\" : \"subscriptionId\",  \"invoiceStatus\" : \"invoiceStatus\",  \"subscriptionPaymentId\" : 0}", Subscriptionpayment.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Subscriptionpayment>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Subscriptionpayment>(HttpStatus.NOT_IMPLEMENTED);
    }

    
    // For Webhooks - START
    public ResponseEntity<Subscriptionpayment> subscriptionpaymentPaymentactionrequiredGET(@RequestBody String payload) {
        //String accept = request.getHeader("Accept");
        //if (accept != null && accept.contains("application/json")) {
    	String endpointSecret = "whsec_7aPM8TmtxgiTAOxNRD28heT0ZcEffcIy";
    	Event event = null;
    	
        try {
        	//StringBuffer jb = new StringBuffer();
        	//String line = null;
			/*
			 * BufferedReader reader = request.getReader(); while ((line =
			 * reader.readLine()) != null) jb.append(line);
			 */
        	
			/*
			 * InputStream is = request.getInputStream(); String payload =
			 * IOUtils.toString(is, StandardCharsets.UTF_8.name());
			 */
    	    
    	    String sigHeader = request.getHeader("Stripe-Signature");
    	    
    	    event = Webhook.constructEvent(payload, sigHeader, endpointSecret);
    	    
    	    EventDataObjectDeserializer dataObjectDeserializer = event.getDataObjectDeserializer();
    	    StripeObject stripeObject = null;
    	    if (dataObjectDeserializer.getObject().isPresent()) {
    	      stripeObject = dataObjectDeserializer.getObject().get();
    	      
    	      System.out.println("Event Info: " + stripeObject);
    	    }

        	System.out.println("Response from Stripe Webhook");
        	System.out.println(request);
            return new ResponseEntity<Subscriptionpayment>(objectMapper.readValue("{  \"subscriptionPaymentId\" : 101,  \"subscriptionId\" : \"sub_IHhn17uFuM6ZQU\",  \"subscriptionStatus\" : \"active\",  \"amount\" : 100,  \"paymentMethod\" : \"card\",  \"invoiceStatus\" : \"paid\",  \"paymentIntentStatus\" : \"succeeded\",  \"customerId\" : \"cus_IHRDXXygHnA2a5\",  \"invoiceId\" : \"in_1HgsLSGpfnkrm8HZNBKS766T\",  \"paymentIntentId\" : \"pi_1HglLWGpfnkrm8HZLre4Ia8B\",  \"subscriptionStart\" : \"29-Oct-2020 10:10:12\",  \"subscriptionEnd\" : \"28-Oct-2022 10:10:12\",  \"trialStart\" : \"29-Oct-2020 10:10:12\",  \"trialEnd\" : \"28-Nov-2020 10:10:12\"}", Subscriptionpayment.class), HttpStatus.NOT_IMPLEMENTED);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<Subscriptionpayment>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //}

        //return new ResponseEntity<Subscriptionpayment>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Subscriptionpayment> subscriptionpaymentPaymentactionrequiredGET() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Subscriptionpayment>(objectMapper.readValue("{  \"subscriptionCustomerId\" : 1,  \"planType\" : \"Professional\",  \"renewalType\" : \"Monthly\",  \"paymentMethod\" : \"card\",  \"trialDays\" : 15,  \"cancelAtPeriodEnd\" : \"Y\"}", Subscriptionpayment.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Subscriptionpayment>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Subscriptionpayment>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Subscriptionpayment> subscriptionpaymentPaymentfailedPOST() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Subscriptionpayment>(objectMapper.readValue("{  \"subscriptionCustomerId\" : 1,  \"planType\" : \"Professional\",  \"renewalType\" : \"Monthly\",  \"paymentMethod\" : \"card\",  \"trialDays\" : 15,  \"cancelAtPeriodEnd\" : \"Y\"}", Subscriptionpayment.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Subscriptionpayment>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Subscriptionpayment>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Subscriptionpayment> subscriptionpaymentPaymentsucceededPOST() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Subscriptionpayment>(objectMapper.readValue("{  \"subscriptionCustomerId\" : 1,  \"planType\" : \"Professional\",  \"renewalType\" : \"Monthly\",  \"paymentMethod\" : \"card\",  \"trialDays\" : 15,  \"cancelAtPeriodEnd\" : \"Y\"}", Subscriptionpayment.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Subscriptionpayment>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Subscriptionpayment>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Message> subscriptionpaymentSchedulecreatedPOST() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Message>(objectMapper.readValue("{  \"message\" : \"message\"}", Message.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Message>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Message>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Message> subscriptionpaymentScheduleexpiresPOST(@ApiParam(value = "" , required=true )  @Valid @RequestBody String body) {
    	String endpointSecret = "whsec_ZxqJh0QnS3vgNKp7IbvdH9pouiYBT49T";
    	
    	Event event = null;
    	StripeObject stripeObject = null;
    	
        try {
        	String sigHeader = request.getHeader("Stripe-Signature");
        	
    	    event = Webhook.constructEvent(body, sigHeader, endpointSecret);
    	    
    	    EventDataObjectDeserializer dataObjectDeserializer = event.getDataObjectDeserializer();
    	    
    	    if (dataObjectDeserializer.getObject().isPresent()) {
    	      stripeObject = dataObjectDeserializer.getObject().get();
    	      
    	      Customer stripeCustomer = (Customer)stripeObject;
    	      
    	      paymentService.notifyPaidSubscriptionExpiring(stripeCustomer);
    	      
				/*
				 * ListIterator<Subscription> subscriptionList =
				 * stripeCustomer.getSubscriptions().getData().listIterator();
				 * 
				 * while (subscriptionList.hasNext()) { Subscription subscription =
				 * subscriptionList.next();
				 * 
				 * subscription.getId() }
				 */
    	      
    	      System.out.println("Event Info: " + stripeObject);
    	    }
    	    
            return new ResponseEntity<Message>(objectMapper.readValue("{  \"message\" : \"message\"}", Message.class), HttpStatus.NOT_IMPLEMENTED);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<Message>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<Message> subscriptionpaymentTrialendsPOST() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Message>(objectMapper.readValue("{  \"message\" : \"message\"}", Message.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Message>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Message>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Message> subscriptionpaymentTrialexpiredPOST(@ApiParam(value = "" ,required=true )  @Valid @RequestBody String body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Message>(objectMapper.readValue("{  \"message\" : \"message\"}", Message.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Message>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Message>(HttpStatus.NOT_IMPLEMENTED);
    }
    
    // For Webhooks - END

}
