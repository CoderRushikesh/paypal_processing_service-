package com.payment.service.interfaces;

import com.payment.dto.TransactionDto;

public interface TransactionStatusProcessor {

	public TransactionDto processStatus(TransactionDto txnDto);
	
}
