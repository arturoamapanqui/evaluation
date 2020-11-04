package com.proximity.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proximity.api.bean.Transaction;
import com.proximity.api.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping(value = "/transaction")
public class TransactionRest {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/{transactionId}")
	@ApiOperation(value = "Get transaction by id")
	public Transaction getTransactionId(@PathVariable("transactionId") Long transactionId) {
		return transactionService.getTransactionId(transactionId);
	}
	
	@GetMapping
	@ApiOperation(value = "Get all transactions available")
	public List<Transaction> getAllTransactions() {
		return transactionService.getAllTransactions();
	}
	
	@PutMapping
	@ApiOperation(value = "Create transaction")
	public Transaction save(@RequestBody Transaction transaction) {
		return transactionService.save(transaction);
	}
	
}
