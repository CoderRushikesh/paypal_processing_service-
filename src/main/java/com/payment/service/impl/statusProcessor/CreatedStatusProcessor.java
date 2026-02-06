package com.payment.service.impl.statusProcessor;

import org.springframework.stereotype.Service;

import com.payment.service.interfaces.TransactionStatusProcessor;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CreatedStatusProcessor implements TransactionStatusProcessor {

	@Override
	public String processStatus(String statusId) {
	 		log.info("Processing 'CREATED' status for transaction: {}", statusId);
	// TODO
	   		
		
		return "Returned from CreatedStatusProcessor";
	}

}
