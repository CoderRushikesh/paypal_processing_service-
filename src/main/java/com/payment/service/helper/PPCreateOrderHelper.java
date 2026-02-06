package com.payment.service.helper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.payment.http.HttpRequest;
import com.payment.paypalprovider.ppCreateOrderReq;
import com.payment.pojo.InitiatePaymentRequest;
import com.payment.util.JsonUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PPCreateOrderHelper {

	private final JsonUtil jsonUtil;
	
	public HttpRequest prepareHttpRequest( 
			String txnReference , InitiatePaymentRequest initiatePaymentRequest) {
		
		  log.info("Preparing HttpRequest for PayPal create Order " + "|| txnReference : {} | initiatePaymentRequest:{}" , txnReference , initiatePaymentRequest);
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ppCreateOrderReq ppCreateOrderReq = new ppCreateOrderReq();
		ppCreateOrderReq.setAmount(1.5);
		ppCreateOrderReq.setCurrencyCode("USd");
		ppCreateOrderReq.setReturnUrl(initiatePaymentRequest.getSuccessUrl());
		ppCreateOrderReq.setCancelUrl(initiatePaymentRequest.getCancleUrl());
		
	   String requestAsJson =	jsonUtil.toJson(ppCreateOrderReq);
		
		HttpRequest httpRequest = new HttpRequest();
		httpRequest.setHttpMethod(HttpMethod.POST);
		httpRequest.setUrl("https://api.sandbox.paypal.com/v2/checkout/orders");
		httpRequest.setHttpHeaders(headers);
		httpRequest.setBody(httpRequest);
		log.info("Prepared HttpRequst for paypal create Order : {}" , httpRequest);
		return httpRequest;
	}
	
}
