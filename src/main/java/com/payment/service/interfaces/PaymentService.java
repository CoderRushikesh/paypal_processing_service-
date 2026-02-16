package com.payment.service.interfaces;

import com.payment.pojo.CreatePaymentRequest;
import com.payment.pojo.InitiatePaymentRequest;
import com.payment.pojo.PaymentResponse;

public interface PaymentService {

public PaymentResponse createPayment(CreatePaymentRequest createPaymentRequest);
	
	public PaymentResponse initiatePayment(String txnReference, 
			InitiatePaymentRequest initiatePaymentRequest);
	
	public PaymentResponse capturePayment(String txnReference);

	
}
