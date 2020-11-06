package com.proximity.api.dao;

import java.util.List;
import com.proximity.api.bean.Machine;

public interface MachineDao {

	List<Machine> getAllMachines();

	Machine getMachineById(Integer machineId);

	Machine save(Machine machine);

	Machine update(Machine machine);

	Machine delete(Integer machineId);

	Machine blockMachine(Integer machineId);

}
