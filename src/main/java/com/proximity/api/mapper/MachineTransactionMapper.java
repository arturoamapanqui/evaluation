package com.proximity.api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.proximity.api.bean.MachineTransaction;

public class MachineTransactionMapper implements RowMapper<MachineTransaction>{

	@Override
	public MachineTransaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		MachineTransaction machineTransaction = new MachineTransaction();
		machineTransaction.setMachineId(rs.getInt("machine_id"));
		machineTransaction.setMachineType(rs.getString("machine_type"));
		machineTransaction.setPaymentMethod(rs.getString("payment_method"));
		machineTransaction.setTransactionId(rs.getInt("transaction_id"));
		machineTransaction.setChange(rs.getDouble("change"));
		machineTransaction.setTransactionDate(rs.getString("transaction_date"));
		machineTransaction.setProductId(rs.getInt("product_id"));
		machineTransaction.setProductName(rs.getString("product_name"));
		
		return machineTransaction;
	}

}
