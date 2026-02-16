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
public class SuccessStatusProcessor implements TransactionStatusProcessor {
	
	private final ModelMapper modelMapper;

	private final TransactionDao transactionDao;

	@Override
	public TransactionDto processStatus(TransactionDto txnDto) {
		log.info("Processing 'SUCCESS' status for txnDto: {}", txnDto);

		// convert DTO to Entity
		TransactionEntity txnEntity = modelMapper.map(
				txnDto, TransactionEntity.class);

		transactionDao.updateTransaction(txnEntity);
		log.info("Updated TransactionEntity in DB for SUCCESS status: {}", txnEntity);

		return txnDto;
	}

}