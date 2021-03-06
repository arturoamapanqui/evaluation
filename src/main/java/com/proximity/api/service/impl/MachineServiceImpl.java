package com.proximity.api.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proximity.api.bean.Machine;
import com.proximity.api.dao.MachineDao;
import com.proximity.api.service.MachineService;

@Service
public class MachineServiceImpl implements MachineService{
	
	@Autowired
	private MachineDao machineDao;
	
	@Override
	public List<Machine> getAllMachines() {
		return machineDao.getAllMachines();
	}

	@Override
	public Machine getMachineById(Integer machineId) {
		return machineDao.getMachineById(machineId);
	}

	@Override
	public Machine save(Machine machine) {
		return machineDao.save(machine);
	}

	@Override
	public Machine update(Machine machine) {
		return machineDao.update(machine);
	}

	@Override
	public Machine delete(Integer machineId) {
		return machineDao.delete(machineId);
	}

	@Override
	public boolean dropBalance(Machine machine) {
		Machine machineQueried = machineDao.getMachineById(machine.getId());
		boolean isCorrect = machineQueried != null ? machine.getPin().equals(machineQueried.getPin()) && !machineQueried.getIsBlocked() : false;
		
		if(!isCorrect) {
			machineDao.blockMachine(machine.getId());
		}
		
		return isCorrect;
	}

	
	
}
