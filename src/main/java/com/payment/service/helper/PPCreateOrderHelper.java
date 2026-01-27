package com.payment.service.helper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.payment.http.HttpRequest;
import com.payment.pojo.InitiatePaymentRequest;

@Service
public class PPCreateOrderHelper {

	
	public HttpRequest prepareHttpRequest( 
			String txnReference , InitiatePaymentRequest initiatePaymentRequest) {
		// TODO Auto-generated method stub
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		
		HttpRequest httpRequest = new HttpRequest();
		httpRequest.setHttpMethod(HttpMethod.POST);
		
		
		httpRequest.setUrl("https://api.sandbox.paypal.com/v2/checkout/orders");
		httpRequest.setHttpHeaders(null);
		httpRequest.setBody(httpRequest);
		return httpRequest;
	}
	
}
