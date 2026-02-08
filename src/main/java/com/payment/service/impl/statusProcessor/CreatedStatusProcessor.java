package com.payment.service.impl.statusProcessor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.payment.dto.TransactionDto;
import com.payment.dto.interfaces.TransactionDao;
import com.payment.entity.TransactionEntity;
import com.payment.service.interfaces.TransactionStatusProcessor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreatedStatusProcessor implements TransactionStatusProcessor {
 
	private final ModelMapper modelMapper;
	private final TransactionDao transactionDao;
	
	@Override
	public TransactionDto processStatus(TransactionDto txnDto) {
	 		log.info("Processing 'CREATED' status for transaction: {}", txnDto);
	
	   TransactionEntity txnEntity  = modelMapper.map(txnDto, TransactionEntity.class);
	log.info("Mapped TransactionEntity : {}" , txnEntity);
	   
TransactionEntity responseEntity = 	transactionDao.createTransaction(txnEntity);  
	log.info("transactionEntity resule " + responseEntity);   
	txnDto.setId(responseEntity.getId());	
	log.info("Updated TransactionDto with ID: {}", txnDto);
	
	return txnDto; 
	}

}
