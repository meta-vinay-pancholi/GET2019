package com.metacube.parking.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.metacube.parking.model.Employee;
import com.metacube.parking.model.EmployeeFriend;
import com.metacube.parking.model.Pass;
import com.metacube.parking.model.VehicleDetails;

@Service
public interface ParkingService {
	public boolean checkDuplicateEmail(String email);
	public boolean addEmployee(Employee emp);
	public Employee getAllData(String email , String password);
	public Employee getDataByEmail(String valueOf);
	public ArrayList<EmployeeFriend> getEmployeeFriendList(String email);
	boolean validatePathId(String id);
	EmployeeFriend getEmployeeFriendListById(String id);
	boolean addEmployeeVechile(VehicleDetails vechile);
	ArrayList<VehicleDetails> getVechileDataByEmployeeId(String id);
	//Price getPriceOfVechileById(String id);
	boolean issueGatePass(Pass gatepass, String id);
	boolean updateEmployeeData(String fileName, String password,
			String organisation, String mobileNumber, String name, String id);
	boolean checkIdIsSame(String empId, int i);
	public Employee getDataById(String string);

}
