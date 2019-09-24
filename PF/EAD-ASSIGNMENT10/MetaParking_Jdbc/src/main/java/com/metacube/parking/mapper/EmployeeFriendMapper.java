package com.metacube.parking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.parking.model.EmployeeFriend;

public class EmployeeFriendMapper implements RowMapper<EmployeeFriend> {

	@Override
	public EmployeeFriend mapRow(ResultSet resultSet, int arg1) throws SQLException {
		EmployeeFriend employeefriend = new EmployeeFriend(resultSet.getInt("id"),
				resultSet.getString("full_name"),
				resultSet.getString("Organisation"),
				resultSet.getString("Contact_number"),
				resultSet.getString("Email_id"),
				resultSet.getString("Gender"),
				resultSet.getString("profile")
		);

		return employeefriend;
	}

}
