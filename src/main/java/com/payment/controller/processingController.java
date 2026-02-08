package com.payment.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.pojo.CreatePaymentRequest;
import com.payment.pojo.InitiatePaymentRequest;
import com.payment.pojo.PaymentResponse;
import com.payment.service.interfaces.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/processes")
@Slf4j
@RequiredArgsConstructor
public class processingController {

	private final PaymentService paymentService;
	
	@PostMapping
	public PaymentResponse createPayment(@RequestBody CreatePaymentRequest createPaymentRequest) {
		log.info("Creating payment... ||createPaymentRequest:{}",
				createPaymentRequest);
		
		PaymentResponse response = paymentService.createPayment(createPaymentRequest);
		log.info("Payment creation response from service: {}", response);
		
		return response;
	}
	
	
	@PostMapping("/{tnxReference}/initiate")
	public String initiatePayment(@PathVariable String tnxReference , 
		 @RequestBody InitiatePaymentRequest initiatePaymentRequest) {
		
		log.info("Initiated payment ...  tnxReference : {} | InitiatePaymentRequest ", tnxReference , initiatePaymentRequest);
		
		String response =	paymentService.initiatePayment(tnxReference , initiatePaymentRequest);
		
		return response ;
	}
	
	
	@PostMapping("/{tnxReference}/capture")
	public String capturePayment(@PathVariable String tnxReference)	 {
		
		log.info("Captured payment ... ");
		
		String response =	paymentService.capturePayment(tnxReference);
		
		return response ;
	}
	
	
}
