package com.payment.service.impl.statusProcessor;

import com.payment.service.interfaces.TransactionStatusProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApprovedStatusProcessor implements TransactionStatusProcessor {

	@Override
	public String processStatus(String statusId) {
		
		
		log.info("Processing 'APPROVED' status for transaction: {}", statusId);
		// TODO Auto-generated method stub
		return null;
	}

}
