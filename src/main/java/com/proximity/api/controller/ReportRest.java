package com.proximity.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proximity.api.bean.MachineTransaction;
import com.proximity.api.service.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping(value = "/report")
public class ReportRest {
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping("/machine/transactions")
	@ApiOperation(value = "Get all transactions per machine")
	public List<MachineTransaction> getMachineTransactions() {
		return reportService.getMachineTransactions();
	}
	
}
