package com.proximity.api.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proximity.api.bean.MachineTransaction;
import com.proximity.api.dao.ReportDao;
import com.proximity.api.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private ReportDao reportDao;

	@Override
	public List<MachineTransaction> getMachineTransactions() {
		return reportDao.getMachineTransactions();
	}
	
}
