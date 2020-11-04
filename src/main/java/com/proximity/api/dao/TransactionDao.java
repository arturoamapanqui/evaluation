package com.proximity.api.dao;

import java.util.List;

import com.proximity.api.bean.Transaction;

public interface TransactionDao {

	Transaction getTransactionId(Long transactionId);

	List<Transaction> getAllTransactions();

	Transaction save(Transaction transaction);

}
