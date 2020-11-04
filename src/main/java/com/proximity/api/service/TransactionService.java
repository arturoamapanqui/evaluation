package com.proximity.api.service;

import java.util.List;

import com.proximity.api.bean.Transaction;

public interface TransactionService {

	Transaction getTransactionId(Long transactionId);

	List<Transaction> getAllTransactions();

	Transaction save(Transaction transaction);

}
