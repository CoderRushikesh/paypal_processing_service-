package com.payment.service.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.payment.dto.TransactionDto;
import com.payment.service.impl.statusProcessor.CreatedStatusProcessor;
import com.payment.service.impl.statusProcessor.InitiatedStatusProcessor;
import com.payment.service.interfaces.TransactionStatusProcessor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class PaymentStatusFactory {

private final ApplicationContext contextProvider;
	
	private final TransactionStatusProcessor createdStatusProcessor;
	
	public TransactionStatusProcessor getProcessor(int statusId) {
		log.info("Getting processor for statusId: {}", statusId);
	
		// switch based on statusId if statusId = 1 
  
		switch (statusId) {
		
		case 1 : 
			log.info("Returning CreatedStatusProcessor for statusId: {}", statusId);
			return contextProvider.getBean("CreatedStatusProcessor", CreatedStatusProcessor.class);
		
		case 2 : 
			log.info("Returing initiatedStatusProcessor for statusId: {}", statusId);
	      return  contextProvider.getBean("InitiatedStatusProcessor", InitiatedStatusProcessor.class);
		
	      
			
			default :
				log.warn("No processor found for statusId: {}", statusId);
				return null;
		}
		
	}
	
}
