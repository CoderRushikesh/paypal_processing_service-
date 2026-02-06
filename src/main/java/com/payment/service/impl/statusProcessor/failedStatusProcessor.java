package com.payment.service.impl.statusProcessor;

import com.payment.service.interfaces.TransactionStatusProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class failedStatusProcessor implements TransactionStatusProcessor {

	@Override
	public String processStatus(String statusId) {
		// TODO Auto-generated method stub
		log.info("Processing 'FAILED' status for transaction: {}", statusId);
		
		return null;
	}

}
