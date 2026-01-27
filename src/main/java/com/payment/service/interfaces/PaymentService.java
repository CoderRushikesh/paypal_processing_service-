package com.payment.service.interfaces;

import com.payment.pojo.CreatePaymentRequest;
import com.payment.pojo.InitiatePaymentRequest;

public interface PaymentService {

	public String createPayment(CreatePaymentRequest createPaymentRequest);
	
	public String initiatePayment(String tnxReference , InitiatePaymentRequest initiatePaymentRequest);
	
	public String capturePayment(String tnxReference);
	
	
	
}
