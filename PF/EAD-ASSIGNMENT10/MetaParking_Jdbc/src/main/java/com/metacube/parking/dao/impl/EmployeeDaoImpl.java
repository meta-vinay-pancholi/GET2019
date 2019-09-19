package com.metacube.parking.dao.impl;

import java.util.ArrayList;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.parking.dao.EmployeeDao;
import com.metacube.parking.mapper.EmployeeFriendMapper;
import com.metacube.parking.mapper.EmployeeMapper;
import com.metacube.parking.mapper.VehicleMapper;
import com.metacube.parking.model.Employee;
import com.metacube.parking.model.EmployeeFriend;
import com.metacube.parking.model.Pass;
import com.metacube.parking.model.VehicleDetails;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private final String INSERT_EMPLOYEE_DATA = "INSERT INTO User (full_name , Email_Id , Password ,Contact_number, Organisation  , Gender) values(?,?,?,?,?,?)";
	private final String INSERT_VECHILE_DATA = "INSERT INTO Vehicle (Name , Type , Vehicle_Number ,Employee_Id, identification) values(?,?,?,?,?)";
	private final String GETALL_EMPLOYEE_DATA = "SELECT * FROM user WHERE Email_id = ? AND Password = ?";
	private final String GET_EMPLOYEE_DATA_BY_ID = "SELECT * FROM User WHERE  id = ?";
	private final String GET_EMPLOYEE_DATA_BY_EMAIL = "SELECT * FROM User WHERE  Email_id = ?";
	private final String GET_EMPLOYEE_FRIEND_DETAILS_BY_EMAIL = "SELECT id ,full_name , Email_Id , Contact_number , Organisation , Gender , profile FROM User WHERE  Organisation = (SELECT Organisation FROM User WHERE Email_Id = ?) AND Email_Id!=?";
	private final String GET_EMPLOYEE_FRIEND_DETAILS_BY_Id = "SELECT id ,full_name , Email_Id , Contact_number , Organisation , Gender  , profile FROM User  where id = ?";
	private final String GET_VECHILE_DETAILS_BY_ID = "SELECT * FROM Vehicle where Employee_Id = ?";
	private final String GET_VECHILE_PRICE_BY_Id = "SELECT * FROM Price WHERE Type = (SELECT Type FROM Vehicle WHERE id = ?)";
	private final String INSERT_GATEPASS_DATA = "INSERT INTO user_vehicle (price , vehicle_id) VALUES(? ,?)";
	private final String UPDATE_EMPLOYEE_DATA = "UPDATE User SET full_name = ? , Password = ? , Contact_number = ? , Organisation = ? , profile = ? where id = ? ";
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void metaDaoMpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	@Override
	public boolean addEmployee(Employee emp) {
		System.out.println(INSERT_EMPLOYEE_DATA);
		return jdbcTemplate.update(INSERT_EMPLOYEE_DATA , emp.getFullname() , emp.getEmail() , emp.getPassword() , emp.getContact() , emp.getOrganisation() , emp.getGender()) > 0;
	}


	@Override
	public Employee getAllData(String email , String password) {
		return jdbcTemplate.queryForObject(GETALL_EMPLOYEE_DATA, new Object[]{email , password} , new EmployeeMapper());
	}


	@Override
	public Employee getDataByEmail(String email) {
		return jdbcTemplate.queryForObject(GET_EMPLOYEE_DATA_BY_EMAIL, new Object[]{email} , new EmployeeMapper());
	}


	@Override
	public ArrayList<EmployeeFriend> getEmployeeFriendList(String email) {	
		return (ArrayList<EmployeeFriend>) jdbcTemplate.query(GET_EMPLOYEE_FRIEND_DETAILS_BY_EMAIL, new Object[]{email , email} , new EmployeeFriendMapper());
	}


	@Override
	public EmployeeFriend getEmployeeFriendListById(String id) {
		return jdbcTemplate.queryForObject(GET_EMPLOYEE_FRIEND_DETAILS_BY_Id, new Object[]{id} , new EmployeeFriendMapper());
	}


	@Override
	public boolean addEmployeeVechile(VehicleDetails vehicle) {
		return jdbcTemplate.update(INSERT_VECHILE_DATA , vehicle.getVehicleName() , vehicle.getVehicleType() ,vehicle.getVehicleNumber() , vehicle.getEmpId() ,vehicle.getIdentification()) > 0;
	}


	@Override
	public ArrayList<VehicleDetails> getVechileDataByEmployeeId(String id) {
		return (ArrayList<VehicleDetails>) jdbcTemplate.query(GET_VECHILE_DETAILS_BY_ID, new Object[]{Integer.parseInt(id)} , new VehicleMapper());
	}




	@Override
	public boolean issueGatePass(Pass gatepass, String id) {
		return jdbcTemplate.update(INSERT_GATEPASS_DATA , gatepass.getCurrency() , Integer.parseInt(id)) > 0;
	}


	@Override
	public boolean updateEmployeeData(String fileName, String password,
			String organisation, String mobileNumber, String name, String id) {
		return jdbcTemplate.update(UPDATE_EMPLOYEE_DATA , name ,password ,mobileNumber ,organisation, fileName ,id) > 0;
	}

	@Override
	public Employee getDataById(String id) {
		return jdbcTemplate.queryForObject(GET_EMPLOYEE_DATA_BY_ID, new Object[]{id} , new EmployeeMapper());
	}
}
