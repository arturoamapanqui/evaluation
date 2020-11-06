package com.proximity.api.dao;

import java.util.List;
import com.proximity.api.bean.MachineTransaction;

public interface ReportDao {

	List<MachineTransaction> getMachineTransactions();

}
