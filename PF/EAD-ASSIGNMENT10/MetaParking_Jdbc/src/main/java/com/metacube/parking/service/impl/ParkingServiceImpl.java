package com.metacube.parking.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.parking.dao.EmployeeDao;
import com.metacube.parking.model.Employee;
import com.metacube.parking.model.EmployeeFriend;
import com.metacube.parking.model.Pass;
import com.metacube.parking.model.VehicleDetails;
import com.metacube.parking.service.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {

	@Autowired
	EmployeeDao employeedaoObj;
	@Override
	public boolean checkDuplicateEmail(String email) {
		return false;
	}

	@Override
	public boolean addEmployee(Employee emp) {
		return employeedaoObj.addEmployee(emp);
	}

	@Override
	public Employee getAllData(String email , String password) {
		return employeedaoObj.getAllData(email , password);
	}

	@Override
	public Employee getDataById(String string) {
		 return employeedaoObj.getDataById(string);
	}

	@Override
	public Employee getDataByEmail(String email) {
		 return employeedaoObj.getDataByEmail(email);
	}

	@Override
	public ArrayList<EmployeeFriend> getEmployeeFriendList(String email) {
		return employeedaoObj.getEmployeeFriendList(email);
	}

	@Override
	public boolean validatePathId(String id) {
		return id.matches("^[0-9]+");
	}
	
	@Override
	public EmployeeFriend getEmployeeFriendListById(String id) {
		return employeedaoObj. getEmployeeFriendListById(id);
	}
	@Override
	public boolean checkIdIsSame(String empId, int i) {
		if(empId.matches("^[0-9]+")) {
			if(Integer.parseInt(empId) == i) {
				return true;
			} 
		}
		return false;
	}

	@Override
	public boolean addEmployeeVechile(VehicleDetails vehicle) {
		return employeedaoObj.addEmployeeVechile(vehicle);
	}
	
	@Override
	public ArrayList<VehicleDetails> getVechileDataByEmployeeId(String id) {
		
		return employeedaoObj.getVechileDataByEmployeeId(id);
	}
//
//	@Override
//	public Price getPriceOfVechileById(String id) {
//		
//		return employeedaoObj.getPriceOfVechileById(id);
//	}
	
	@Override
	public boolean issueGatePass(Pass gatepass,
			String id) {
		return employeedaoObj.issueGatePass(gatepass,id);
	}
	
	@Override
	public boolean updateEmployeeData(String fileName, String password,
			String organisation, String mobileNumber, String name, String id) {
	
		return employeedaoObj.updateEmployeeData( fileName,  password,
				 organisation,  mobileNumber,  name , id);
	}


	
	
}
