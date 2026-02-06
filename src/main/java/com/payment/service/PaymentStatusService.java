package com.payment.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.payment.constant.ErrorCodeEnum;
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

	public String processPayment(int statusId) {
	log.info("Processing payment status appropriate processor based on statusId ");	
	
	// TODO invoke factory to get the correct object of the processor based on statusId 
	TransactionStatusProcessor processor = paymentStatusFactory.getProcessor(statusId);
       
	
	if(processor == null) {
		log.error("No processor found for statusId: {}" , statusId);
		throw new ProcessingServiceException(
		ErrorCodeEnum.NO_STATUS_PROCESSOR_FOUND.getErrorCode(), ErrorCodeEnum.NO_STATUS_PROCESSOR_FOUND.getErrorMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	TransactionStatusProcessor processor = null;
	
	String response =	processor.processStatus(statusId + " ");
		
	 log.info("Processed payment status with response : {}" , response);
		return "Processed payment with statusId : " + statusId;
	}
	
}
