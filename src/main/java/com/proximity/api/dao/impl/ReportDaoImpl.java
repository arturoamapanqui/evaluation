package com.proximity.api.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.proximity.api.bean.MachineTransaction;
import com.proximity.api.dao.ReportDao;
import com.proximity.api.mapper.MachineTransactionMapper;

@Component
public class ReportDaoImpl implements ReportDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private final String QUERY_MACHINE_TRANSACTIONS = "select pm.id as machine_id, pmt.name as machine_type, ppm.name as payment_method, pt.id as transaction_id, pt.change, to_char(pt.cdate, 'dd/mm/yyyy') as transaction_date, pp.id as product_id, pp.name as product_name " + 
														"from 	proximity_machine pm " + 
														"inner join proximity_machine_type pmt on pm.machine_type = pmt.id " + 
														"inner join proximity_transaction pt on pm.id = pt.machine_id " + 
														"inner join proximity_product pp on pp.id = pt.product_id " + 
														"inner join proximity_payment_method ppm on ppm.id = pt.payment_method";
	
	@Override
	public List<MachineTransaction> getMachineTransactions() {
		return jdbcTemplate.query(QUERY_MACHINE_TRANSACTIONS, new Object[]{},new MachineTransactionMapper());
	}

	
	
}
