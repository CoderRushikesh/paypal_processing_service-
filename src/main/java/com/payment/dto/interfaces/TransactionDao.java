package com.payment.dto.interfaces;

import com.payment.entity.TransactionEntity;

public interface TransactionDao {

	public TransactionEntity createTransaction(TransactionEntity transaction);
	public TransactionEntity getTransactionByTxnReference(String txnReference);
	
	public void updateTransaction(TransactionEntity transaction);
	
}
