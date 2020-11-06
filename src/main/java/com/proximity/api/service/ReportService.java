package com.proximity.api.service;

import java.util.List;
import com.proximity.api.bean.MachineTransaction;

public interface ReportService {

	List<MachineTransaction> getMachineTransactions();

}
