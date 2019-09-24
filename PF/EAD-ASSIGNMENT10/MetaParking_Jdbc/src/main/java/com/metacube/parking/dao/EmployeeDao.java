package com.metacube.parking.dao;

import java.util.ArrayList;
import java.util.List;

import com.metacube.parking.model.Employee;
import com.metacube.parking.model.EmployeeFriend;
import com.metacube.parking.model.Pass;
import com.metacube.parking.model.VehicleDetails;

public interface EmployeeDao {
	public boolean addEmployee(Employee emp);
	public  Employee getAllData(String email , String password);
	public Employee getDataById(String string);
	public Employee getDataByEmail(String email);
	public ArrayList<EmployeeFriend> getEmployeeFriendList(String email);
	public EmployeeFriend getEmployeeFriendListById(String id);
	public boolean addEmployeeVechile(VehicleDetails vechile);
	public ArrayList<VehicleDetails> getVechileDataByEmployeeId(String id);
	//public Price getPriceOfVechileById(String id);
	public boolean issueGatePass(Pass gatepass, String id);
	public boolean updateEmployeeData(String fileName, String password,String organisation, String mobileNumber, String name, String id);

}
