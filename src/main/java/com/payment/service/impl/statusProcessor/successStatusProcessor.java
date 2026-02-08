package com.payment.service.impl.statusProcessor;

import com.payment.dto.TransactionDto;
import com.payment.service.interfaces.TransactionStatusProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class successStatusProcessor implements TransactionStatusProcessor {

	@Override
	public TransactionDto processStatus(TransactionDto statusId) {
		// TODO Auto-generated method stub
		log.info("Processing 'SUCCESS' status for transaction: {}", statusId);
		return null;
	}

}
