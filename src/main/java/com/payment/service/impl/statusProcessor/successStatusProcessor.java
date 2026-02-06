package com.payment.service.impl.statusProcessor;

import com.payment.service.interfaces.TransactionStatusProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class successStatusProcessor implements TransactionStatusProcessor {

	@Override
	public String processStatus(String statusId) {
		// TODO Auto-generated method stub
		log.info("Processing 'SUCCESS' status for transaction: {}", statusId);
		return null;
	}

}
