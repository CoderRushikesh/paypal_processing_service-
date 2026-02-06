package com.payment.pojo;

import lombok.Data;

@Data
public class InitiatePaymentRequest {

	private String successUrl;
	private String cancleUrl;
	
}
