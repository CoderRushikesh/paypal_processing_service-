package com.payment.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.payment.http.HttpRequest;
import com.payment.http.HttpServiceEngine;
import com.payment.pojo.CreatePaymentRequest;
import com.payment.pojo.InitiatePaymentRequest;
import com.payment.pojo.PaymentResponse;
import com.payment.service.PaymentStatusService;
import com.payment.service.helper.PPCreateOrderHelper;
import com.payment.service.interfaces.PaymentService;
import com.payment.service.interfaces.TransactionStatusProcessor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

	private final PPCreateOrderHelper ppCreateOrderHelper;
	private final HttpServiceEngine httpServiceEngine;
//	private final TransactionStatusProcessor TransactionStatusProcessor ;
	private final PaymentStatusService paymentStatusService;
	@Override
	public String createPayment(CreatePaymentRequest createPaymentRequest) {
	 log.info("Created  payment ... ||createPaymentRequest:{}", createPaymentRequest);
		
	 
	 
	 String response = paymentStatusService.processPayment(1);
 
	 log.info("Response from TransactionStatusProcessor : {} " , response);
	 
	 return  "Payment created successfully !" + createPaymentRequest +"\n" + response ;
	}
	
	
	
	
	
	
	
	@Override
	public String initiatePayment(String tnxReference , InitiatePaymentRequest initiatePaymentRequest)	 {
		log.info("Initiated payment ...  tnxReference : {} ", tnxReference);
			  
		// make api call to paypal-provider to creareOrder api 
		/*
		 * 1 Prepare HttpRequest 
		 *  2 pass to httpServiceEngine
		 *  3 process the response 
		 *  
		 */
		
		HttpRequest httpReq = ppCreateOrderHelper.prepareHttpRequest(tnxReference, initiatePaymentRequest);
	   log.info(" Prepared HttpRequest for PayPal Provider create Order {} " , httpReq);
	   
	  ResponseEntity<String> httpResponse =   httpServiceEngine.makeHttpRequest(httpReq);
	   
	   
		return "payment initiated successfully !" + tnxReference + " " + initiatePaymentRequest + " | " + httpResponse.getBody() ;
	}
	
	
	
	
	@Override
	public String capturePayment(String tnxReference)	 {
	  log.info("Captured payment ...  tnxReference : {} ", tnxReference);
		return "payment captured successfully ! tnxReference : " + tnxReference ;
	}
	
	
	
}
