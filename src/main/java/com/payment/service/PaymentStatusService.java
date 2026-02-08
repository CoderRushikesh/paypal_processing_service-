package com.payment.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.payment.constant.ErrorCodeEnum;
import com.payment.dto.TransactionDto;
import com.payment.exception.ProcessingServiceException;
import com.payment.service.factory.PaymentStatusFactory;
import com.payment.service.interfaces.TransactionStatusProcessor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentStatusService {

   private final PaymentStatusFactory paymentStatusFactory;
//   private final TransactionStatusProcessor  processor;
	public TransactionDto processPayment(TransactionDto txnDto) {
	log.info("Processing payment status appropriate processor based on statusId ");	
	
   int statusId = txnDto.getTxnStatusId(); 
	TransactionStatusProcessor processor = paymentStatusFactory.getProcessor(statusId);
       
	
	if(processor == null) {
		log.error("No processor found for statusId: {}" , txnDto);
		throw new ProcessingServiceException(
		ErrorCodeEnum.NO_STATUS_PROCESSOR_FOUND.getErrorCode(), ErrorCodeEnum.NO_STATUS_PROCESSOR_FOUND.getErrorMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	TransactionStatusProcessor processor = null;
	
	TransactionDto response =	processor.processStatus(txnDto );
		
	 log.info("Processed payment status with response : {}" , response);
		return response;
	}
	
}
