package com.payment.service.impl;

import org.springframework.stereotype.Service;

import com.payment.pojo.CreatePaymentRequest;
import com.payment.pojo.InitiatePaymentRequest;
import com.payment.service.interfaces.PaymentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

	
	
	@Override
	public String createPayment(CreatePaymentRequest createPaymentRequest) {
	 log.info("Created  payment ... ");
		return "payment Created successfully !" ;
	}
	
	
	
	@Override
	public String initiatePayment(String tnxReference , InitiatePaymentRequest initiatePaymentRequest)	 {
		log.info("Initiated payment ...  tnxReference : {} ", tnxReference);
		return "payment initiated successfully !" + tnxReference + " " + initiatePaymentRequest ;
	}
	
	@Override
	public String capturePayment(String tnxReference)	 {
	  log.info("Captured payment ...  tnxReference : {} ", tnxReference);
		return "payment captured successfully ! tnxReference : " + tnxReference ;
	}
}
