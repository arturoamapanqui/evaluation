package com.proximity.api.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.proximity.api.bean.Transaction;
import com.proximity.api.dao.TransactionDao;
import com.proximity.api.mapper.TransactionMapper;

@Component
public class TransactionDaoImpl implements TransactionDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private final String QUERY_TRANSACTION_BY_ID = "select pt.id as transactionId, to_char(pt.cdate, 'dd/mm/yyyy') as date, pm.id as machineId, pm.balance, pm.capacity, pp.id as productId, pp.name as productName, pp.cost, ppm.id as paymentmethodid, ppm.name as paymentmethodname "
			+ "from proximity_transaction pt inner join proximity_machine pm on pt.machine_id = pm.id inner join proximity_product pp on pt.product_id = pp.id "
			+ "inner join proximity_payment_method ppm on ppm.id = pt.payment_method"
			+ "where pt.id = ?";
	
	private final String QUERY_TRANSACTION = "select pt.id as transactionId, to_char(pt.cdate, 'dd/mm/yyyy') as date, pm.id as machineId, pm.balance, pm.capacity, pp.id as productId, pp.name as productName, pp.cost, ppm.id as paymentmethodid, ppm.name as paymentmethodname "		
							+ "from proximity_transaction pt inner join proximity_machine pm on pt.machine_id = pm.id inner join proximity_product pp on pt.product_id = pp.id "
							+ "inner join proximity_payment_method ppm on ppm.id = pt.payment_method ";
	
	private final String SAVE_TRANSACTION = "insert into proximity_transaction(machine_id,product_id,change,payment_method,cdate) values (?,?,?,?,now())";
	
	@Override
	public Transaction getTransactionId(Long transactionId) {
		return jdbcTemplate.queryForObject(QUERY_TRANSACTION_BY_ID, new Object[]{transactionId},new TransactionMapper());
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return jdbcTemplate.query(QUERY_TRANSACTION, new Object[]{},new TransactionMapper());
	}

	@Override
	public Transaction save(Transaction transaction) {
		int result = jdbcTemplate.update(SAVE_TRANSACTION, new Object[]{transaction.getMachine().getId(), transaction.getProduct().getId(), transaction.getChange(),transaction.getPaymentMethod().getId()});
		return result == 1 ? transaction : null;
	}

}
