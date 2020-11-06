package com.proximity.api.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.proximity.api.bean.Machine;
import com.proximity.api.dao.MachineDao;
import com.proximity.api.mapper.MachineMapper;

@Component
public class MachineDaoImpl implements MachineDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private final String QUERY_MACHINE_BY_ID = "select m.id, m.capacity, mt.id as typeId, mt.name, m.balance, (m.is_connected) as is_connected, (case when m.capacity >= 100 then true else false end) ready_pickup, is_blocked, pin from proximity_machine m inner join proximity_machine_type mt on m.machine_type = mt.id where m.id = ?";
	
	private final String QUERY_MACHINE = "select m.id, m.capacity, mt.id as typeId, mt.name, m.balance, (m.is_connected) as is_connected, (case when m.capacity >= 100 then true else false end) ready_pickup, is_blocked from proximity_machine m inner join proximity_machine_type mt on m.machine_type = mt.id";
	
	private final String SAVE_MACHINE = "insert into proximity_machine (capacity, machine_type, balance, pin) values (?,?,?,?)";
	
	private final String UPDATE_MACHINE = "update proximity_machine set capacity = ?, machine_type = ?, balance = ?, pin = ? where id = ?";
	
	private final String DELETE_MACHINE = "delete from proximity_machine where id = ?";
	
	private final String BLOCK_MACHINE = "update proximity_machine set is_blocked = true where id = ?";
	
	@Override
	public List<Machine> getAllMachines() {
		return jdbcTemplate.query(QUERY_MACHINE, new Object[]{},new MachineMapper());
	}

	@Override
	public Machine getMachineById(Integer machineId) {
		return jdbcTemplate.queryForObject(QUERY_MACHINE_BY_ID, new Object[]{machineId},new MachineMapper());
	}

	@Override
	public Machine save(Machine machine) {
		int result = jdbcTemplate.update(SAVE_MACHINE, new Object[]{machine.getCapacity(), machine.getType().getId(), machine.getBalance(), machine.getPin()});
		return result == 1 ? machine : null;
	}

	@Override
	public Machine update(Machine machine) {
		int result = jdbcTemplate.update(UPDATE_MACHINE, new Object[]{machine.getCapacity(), machine.getType().getId(), machine.getBalance(), machine.getPin(),machine.getId()});
		return result == 1 ? machine : null;
	}

	@Override
	public Machine delete(Integer machineId) {
		int result = jdbcTemplate.update(DELETE_MACHINE, new Object[]{machineId});
		return result == 1 ? new Machine(): null;
	}

	@Override
	public Machine blockMachine(Integer machineId) {
		int result = jdbcTemplate.update(BLOCK_MACHINE, new Object[]{machineId});
		return result == 1 ? new Machine(): null;
	}

}
