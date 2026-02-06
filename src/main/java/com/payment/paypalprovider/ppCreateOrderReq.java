package com.payment.paypalprovider;

import lombok.Data;

@Data
public class ppCreateOrderReq {

	private String currencyCode;
	private Double amount;
	private String returnUrl;
	private String cancelUrl;
	
}
