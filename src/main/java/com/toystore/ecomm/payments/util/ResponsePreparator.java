package com.toystore.ecomm.payments.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.toystore.ecomm.payments.factory.UIModelFactory;
import com.toystore.ecomm.payments.model.Data;
import com.toystore.ecomm.payments.model.Data1;
import com.toystore.ecomm.payments.model.Paymentresponse;
import com.toystore.ecomm.payments.model.SubscriptionPaymentInfo;
import com.toystore.ecomm.payments.model.Subscriptioncustomerresponse;
import com.toystore.ecomm.payments.model.Subscriptionpaymentresponse;
import com.toystore.ecomm.payments.model.Subscriptionproductresponse;

@Component
public class ResponsePreparator {

	static {
		mapper = new ObjectMapper();
	}

	private static ObjectMapper mapper;

	private static boolean toExcludeNull;

	@Value("${config.response.format.exclude.null}")
	public void setToExcludeNull(boolean value) {
		toExcludeNull = value;
	}

	public static String preparePaymentResponse(Object dataInfo, String msg, boolean isSuccess, Integer errorCode)
				  throws IllegalAccessException, InstantiationException {

		Data data = null;

		if (dataInfo != null) {
			data = (Data) UIModelFactory.getInstance("DATA");
			data.setId((Integer) dataInfo);
		}

		Paymentresponse paymentResponse = (Paymentresponse) UIModelFactory.getInstance("PAYMENTRESP");
		paymentResponse.setData(data);
		paymentResponse.setErrorCode(errorCode);
		paymentResponse.setMessage(msg);
		paymentResponse.setSuccess(isSuccess);

		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		if (toExcludeNull)
			mapper.setSerializationInclusion(Include.NON_NULL);
		else
			mapper.setSerializationInclusion(Include.ALWAYS);

		String paymentRespStr = null;
		try {
			paymentRespStr = mapper.writeValueAsString(paymentResponse);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return paymentRespStr;
	}

	public static String prepareSubscriptionPaymentResponse(Object dataInfo, String msg, boolean isSuccess,
															Integer errorCode) throws IllegalAccessException, InstantiationException, JsonProcessingException {

		Data1 data = null;

		if (dataInfo != null) {
			
			if (dataInfo instanceof SubscriptionPaymentInfo) {
				data = (Data1) UIModelFactory.getInstance("DATA1");
				
				data.setId(((SubscriptionPaymentInfo) dataInfo).getSubscriptionPaymentId());
				
				Date subscriptionStartDate = ((SubscriptionPaymentInfo) dataInfo).getSubscriptionStart();
				Date subscriptionEndDate = ((SubscriptionPaymentInfo) dataInfo).getSubscriptionEnd();
				
				Date trialStartDate = ((SubscriptionPaymentInfo) dataInfo).getTrialStart();
				Date trialEndDate = ((SubscriptionPaymentInfo) dataInfo).getTrialEnd();
				
				if (subscriptionStartDate != null && subscriptionEndDate != null) {
					data.setStartDate(subscriptionStartDate.toString());
					data.setEndDate(subscriptionEndDate.toString());
				} else {
					data.setStartDate(trialStartDate.toString());
					data.setEndDate(trialEndDate.toString());
				}
			}
		}

		Subscriptionpaymentresponse paymentResponse = (Subscriptionpaymentresponse) UIModelFactory.getInstance("SUBSCRIPTIONPAYMENTRESP");
		paymentResponse.setData(data);
		paymentResponse.setErrorCode(errorCode);
		paymentResponse.setMessage(msg);
		paymentResponse.setSuccess(isSuccess);

		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		if (toExcludeNull)
			mapper.setSerializationInclusion(Include.NON_NULL);
		else
			mapper.setSerializationInclusion(Include.ALWAYS);

		String paymentRespStr = mapper.writeValueAsString(paymentResponse);
		
		return paymentRespStr;
	}

	public static String prepareSubscriptionCustomerResponse(Object dataInfo, String msg, boolean isSuccess,
															 Integer errorCode) throws IllegalAccessException, InstantiationException {

		Data data = null;

		if (dataInfo != null) {
			data = (Data) UIModelFactory.getInstance("DATA");
			data.setId((Integer) dataInfo);
		}

		Subscriptioncustomerresponse customerResponse = (Subscriptioncustomerresponse) UIModelFactory.getInstance("SUBSCRIPTIONCUSTOMERRESP");
		
		customerResponse.setData(data);
		customerResponse.setErrorCode(errorCode);
		customerResponse.setMessage(msg);
		customerResponse.setSuccess(isSuccess);

		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		if (toExcludeNull)
			mapper.setSerializationInclusion(Include.NON_NULL);
		else
			mapper.setSerializationInclusion(Include.ALWAYS);

		String paymentRespStr = null;
		try {
			paymentRespStr = mapper.writeValueAsString(customerResponse);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return paymentRespStr;
	}

	public static String prepareSubscriptionProductResponse(Object dataInfo, String msg, boolean isSuccess,
															 Integer errorCode) throws IllegalAccessException, InstantiationException {

		Data data = null;

		if (dataInfo != null) {
			data = (Data) UIModelFactory.getInstance("DATA");
			data.setId((Integer) dataInfo);
		}

		Subscriptionproductresponse productResponse = (Subscriptionproductresponse) UIModelFactory.getInstance("SUBSCRIPTIONPRODUCTRESP");
		
		productResponse.setData(data);
		productResponse.setErrorCode(errorCode);
		productResponse.setMessage(msg);
		productResponse.setSuccess(isSuccess);

		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		if (toExcludeNull)
			mapper.setSerializationInclusion(Include.NON_NULL);
		else
			mapper.setSerializationInclusion(Include.ALWAYS);

		String paymentRespStr = null;
		try {
			paymentRespStr = mapper.writeValueAsString(productResponse);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return paymentRespStr;
	}
}
