package com.proximity.api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.proximity.api.bean.Machine;
import com.proximity.api.bean.PaymentMethod;
import com.proximity.api.bean.Product;
import com.proximity.api.bean.Transaction;

public class TransactionMapper implements RowMapper<Transaction>{

	@Override
	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		Transaction transaction = new Transaction();
		transaction.setId(rs.getInt("transactionId"));
		transaction.setDate(rs.getString("date"));
		
		Machine machine = new Machine();
		machine.setId(rs.getInt("machineId"));
		machine.setBalance(rs.getDouble("balance"));
		machine.setCapacity(rs.getInt("capacity"));
		
		Product product = new Product();
		product.setId(rs.getInt("productId"));
		product.setName(rs.getString("productName"));
		product.setCost(rs.getDouble("cost"));
		
		PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setId(rs.getInt("paymentmethodid"));
		paymentMethod.setName(rs.getString("paymentmethodname"));
		
		transaction.setProduct(product);
		transaction.setMachine(machine);
		transaction.setPaymentMethod(paymentMethod);
		
		return transaction;
	}

}
