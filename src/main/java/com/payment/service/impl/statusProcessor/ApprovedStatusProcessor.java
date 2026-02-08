package com.payment.service.impl.statusProcessor;

import com.payment.dto.TransactionDto;
import com.payment.service.interfaces.TransactionStatusProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApprovedStatusProcessor implements TransactionStatusProcessor {

	@Override
	public TransactionDto processStatus(TransactionDto statusId) {
		
		
		log.info("Processing 'APPROVED' status for transaction: {}", statusId);
		// TODO Auto-generated method stub
		return null;
	}

}
