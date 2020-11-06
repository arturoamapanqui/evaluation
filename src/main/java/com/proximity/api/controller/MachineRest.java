package com.proximity.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proximity.api.bean.Machine;
import com.proximity.api.service.MachineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping(value = "/machine")
public class MachineRest {
	
	@Autowired
	private MachineService machineService;
	
	
	@GetMapping("/{machineId}")
	@ApiOperation(value = "Get machine by id")
	public Machine getMachineById(@PathVariable("machineId") Integer machineId) {
		return machineService.getMachineById(machineId);
	}
	
	@GetMapping
	@ApiOperation(value = "Get all machines available")
	public List<Machine> getAllMachines() {
		return machineService.getAllMachines();
	}
	
	@PutMapping
	@ApiOperation(value = "Create machine")
	public Machine save(@RequestBody Machine machine) {
		return machineService.save(machine);
	}
	
	@PostMapping
	@ApiOperation(value = "Update machine")
	public Machine update(@RequestBody Machine machine) {
		return machineService.update(machine);
	}
	
	@DeleteMapping("/{machineId}")
	@ApiOperation(value = "Delete machine")
	public Machine delete(@PathVariable("machineId") Integer machineId) {
		return machineService.delete(machineId);
	}
	
	@PostMapping("/drop-balance")
	public boolean dropBalance(@RequestBody Machine machine) {
		return machineService.dropBalance(machine);
	}
	
}
