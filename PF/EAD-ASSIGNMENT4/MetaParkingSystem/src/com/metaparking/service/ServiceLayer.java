package com.metaparking.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metaparking.dao.DaoLayer;
import com.metaparking.model.Price;
import com.metaparking.model.User;
import com.metaparking.model.UserFriendList;
import com.metaparking.model.VehicleDetails;

public class ServiceLayer {
	DaoLayer DaoLayerObj = new DaoLayer();

	public ArrayList<String> validateUserData(String name, String gender,
			String phone, String email, String org, String pass, String conpass) throws SQLException {
		 ArrayList<String> errorList = new ArrayList<String>();

		 if (name.length() <= 3) {
		 errorList.add("Size of name should be greater than 3");

		 } else if (name.matches("\\d")) {
		 errorList.add("Invalid name ");
		 }

		 if (!(email.matches(
		 "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"))) {
		 errorList.add("Invalid Email");
		 }

		 if ("null".equals(org)) {
		 errorList.add("Invalid organisation ");
		 }

		 if (pass.length() < 8) {
		 errorList.add("Password length should be grtaer than 8");
		 
		 } else if (!pass.equals(conpass)) {
		 errorList.add("Password do not match");
		 
		 } 
		 if (phone.length() != 10) {
		 errorList.add("Phone length should be equal to 10");
		 
		 } 
		 if(gender == null) {
		 errorList.add("Invalid gender");
		 }

		 if (errorList.size() <= 0) {
			 int result = DaoLayerObj.registerUser(name,email,org,pass,phone,gender);
			 if(result == 1) {
				 return null;
			 }
		 }
		 
		 
		 return errorList;

	}

	public ResultSet authenticateUser(String pass, String email) throws SQLException {
		
		return DaoLayerObj.loginUser(email, pass);
	}

	public ArrayList<String> validateVehicleData(String vname, String vtype,
			String vnumber, String empid, String identy) throws SQLException {
		 ArrayList<String> errorList = new ArrayList<String>();

		if (!(vnumber.matches("^[A-Za-z]{2}[0-9]{6}$"))) {
			errorList.add("Enter valid vehicle number");
		}
		
		if(vname == null) {
			errorList.add("Vehicle name cant be null");
		}
	    
		if(vtype == null) {
			errorList.add("Choose a vehicle type");
		}
		
		 if (errorList.size() <= 0) {
			 int result = DaoLayerObj.registerVehicle(vname,vnumber,empid,vtype,identy);
			 if(result == 1) {
				 return null;
			 }
		 }
		return errorList;
		 
	}

	public ArrayList getFriendOfUser(String user) throws SQLException {
		ArrayList<UserFriendList> user_friend = new ArrayList<UserFriendList>();
		ResultSet rs =  DaoLayerObj.getFriendOfUser(user);
		while(rs.next()){
			System.out.println(rs.getInt("Id"));
			user_friend.add(new UserFriendList(rs.getInt("id"),rs.getString("full_name"),rs.getString("Organisation"),rs.getString("Contact_number"),rs.getString("Email_Id")));
		}
		return user_friend;
	}
	
	public ArrayList<VehicleDetails> getVeichleDetails(String empId) throws SQLException {
		ResultSet rs = DaoLayerObj. getVeichleDetails(empId);
		ArrayList<VehicleDetails> employeeVehicleDetails = new ArrayList<VehicleDetails>();
		while(rs.next()){
			employeeVehicleDetails.add(new VehicleDetails(rs.getInt("id"), rs.getString("Vehicle_Number"), rs.getString("Type")));
		}
		return employeeVehicleDetails;

	}

	/**
	 * function is used to validate the vechile details when data come from the get method
	 * @param vehcileId
	 * @param vechileType
	 * @return
	 */
	public boolean validateVehicleData(String vehcileId, String vechileType) {
		boolean id = true;
		boolean type = true;
		if(!(vehcileId.matches("^[0-9]+$"))) {
			id= false;
		}

		if(!(vechileType.matches("^[A-Za-z\\s]+$"))) {
			 type = false;
		}

		if(id&&type) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * function is used to get complete price of vechile type
	 * @param vechileType
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Price> getPriceOfVechile( String vechileType) throws SQLException {
		ArrayList<Price> priceOfVechile = new ArrayList<Price>();
		ResultSet rs = DaoLayerObj.getPriceOfVechile(vechileType);
		while(rs.next()){
			priceOfVechile.add(new Price(rs.getInt("id") ,rs.getString("Type") ,rs.getInt("DAILY") ,rs.getInt("Monthly"),rs.getInt("Yearly")));
		}
		return priceOfVechile;

	}

	/**
	 * function is used to register the gate pass in table
	 * @param price
	 * @param vid
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	public int createAGatePAss(int price, int vid, int uid) throws SQLException {
		return DaoLayerObj.createAGatePAss(price, vid, uid);
	}

	/**
	 * function is used to get complete imformation about user
	 * @param userID
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<User> getUserData(String userID) throws SQLException {
		ArrayList<User> alluserData = new ArrayList<User>();
		ResultSet rs = DaoLayerObj.gateUserData(userID);
		while(rs.next()){
			alluserData.add(new User(rs.getInt("id"), rs.getString("full_name"), rs.getString("Password"), rs.getString("Contact_number")));
		}
		return alluserData;
	}

	/**
	 * function is used to update the data of user
	 * @param name
	 * @param password
	 * @param contact
	 * @param userID
	 * @return
	 * @throws SQLException
	 */

	public int UpdateUserData(String name, String password, String contact,
			String userID) throws SQLException {
		return DaoLayerObj.UpdateUserData(name, password, contact ,userID);
	}
}
