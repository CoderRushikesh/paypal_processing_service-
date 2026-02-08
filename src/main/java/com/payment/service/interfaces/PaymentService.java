package com.payment.service.interfaces;

import com.payment.pojo.CreatePaymentRequest;
import com.payment.pojo.InitiatePaymentRequest;
import com.payment.pojo.PaymentResponse;

public interface PaymentService {

	public PaymentResponse createPayment(CreatePaymentRequest createPaymentRequest);
	
	public String initiatePayment(String tnxReference , InitiatePaymentRequest initiatePaymentRequest);
	
	public String capturePayment(String tnxReference);
	
	
	
}
