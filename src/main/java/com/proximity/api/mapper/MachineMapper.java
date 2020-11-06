package com.proximity.api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.proximity.api.bean.Machine;
import com.proximity.api.bean.MachineType;

public class MachineMapper implements RowMapper<Machine>{

	@Override
	public Machine mapRow(ResultSet rs, int rowNum) throws SQLException {
		Machine machine = new Machine();
		machine.setId(rs.getInt("id"));
		machine.setCapacity(rs.getInt("capacity"));
		machine.setBalance(rs.getDouble("balance"));
		machine.setIsConnected(rs.getBoolean("is_connected"));
		machine.setIsReadyToPickup(rs.getBoolean("ready_pickup"));
		machine.setIsBlocked(rs.getBoolean("is_blocked"));
		machine.setPin(rs.getInt("pin"));
		
		MachineType type = new MachineType();
		type.setId(rs.getInt("typeId"));
		type.setName(rs.getString("name"));
		
		machine.setType(type);
		
		return machine;
	}

}
