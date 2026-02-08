package com.payment.dto.interfaces;

import com.payment.entity.TransactionEntity;

public interface TransactionDao {

	public TransactionEntity createTransaction(TransactionEntity transaction);
	
	
}
