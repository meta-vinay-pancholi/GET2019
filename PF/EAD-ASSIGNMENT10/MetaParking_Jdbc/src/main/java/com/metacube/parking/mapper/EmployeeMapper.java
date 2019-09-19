package com.metacube.parking.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.parking.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee(rs.getInt("id"),
				rs.getString("full_name"),
				rs.getString("Email_id"),
				rs.getString("Contact_number"),
				rs.getString("Organisation"),
				rs.getString("Gender"),
				rs.getString("Password"),
				rs.getString("profile")
				);

		return employee;
	}

}