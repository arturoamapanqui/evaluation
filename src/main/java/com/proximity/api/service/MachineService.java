package com.proximity.api.service;

import java.util.List;
import com.proximity.api.bean.Machine;

public interface MachineService {
	
	List<Machine> getAllMachines();

	Machine getMachineById(Long machineId);

	Machine save(Machine machine);

	Machine update(Machine machine);

	Machine delete(Long machineId);
	
}
