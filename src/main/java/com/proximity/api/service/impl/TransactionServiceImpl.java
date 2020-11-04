package com.proximity.api.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proximity.api.bean.Transaction;
import com.proximity.api.dao.TransactionDao;
import com.proximity.api.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Override
	public Transaction getTransactionId(Long transactionId) {
		return transactionDao.getTransactionId(transactionId);
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return transactionDao.getAllTransactions();
	}

	@Override
	public Transaction save(Transaction transaction) {
		transaction.setChange(transaction.getAmount() - transaction.getAmountInserted());
		transaction.setChangeCoins(getChangeCoins(transaction.getChange()));
		return transactionDao.save(transaction);
	}

	private HashMap<String, Integer> getChangeCoins(Double amount) {
		int change = (int) (Math.ceil(amount * 100));
		
		int cents50 = Math.round((int) change / 50);
		change = change % 50;
		
		int cents25 = Math.round((int) change / 25);
		change = change % 25;
		
		int cents10 = Math.round((int) change / 10);
		change = change % 10;
		
		int cents5 = Math.round((int) change / 5);
		change = change % 5;
		
		HashMap<String, Integer> changeCoins = new HashMap<String, Integer>();
		changeCoins.put("COINS_50_CENTS", cents50);
		changeCoins.put("COINS_25_CENTS", cents25);
		changeCoins.put("COINS_10_CENTS", cents10);
		changeCoins.put("COINS_5_CENTS", cents5);
		
		return changeCoins;
	}

}
