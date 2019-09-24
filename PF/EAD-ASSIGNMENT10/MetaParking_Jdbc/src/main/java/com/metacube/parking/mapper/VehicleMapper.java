package com.metacube.parking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.parking.model.VehicleDetails;

public class VehicleMapper implements RowMapper<VehicleDetails> {

	@Override
	public VehicleDetails mapRow(ResultSet resultSet, int arg1) throws SQLException {
		VehicleDetails vechileDetails = new VehicleDetails(resultSet.getInt("id"),
				resultSet.getString("vehicleName"),
				resultSet.getString("vehicleType"),
				resultSet.getString("vehicleNumber"),
				resultSet.getString("empId"),
				resultSet.getString("identification")
		);

		return vechileDetails;
	}

}