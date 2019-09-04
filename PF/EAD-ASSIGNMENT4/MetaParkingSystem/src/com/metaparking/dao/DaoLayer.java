package com.metaparking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoLayer {

	public int registerUser(String name, String email, String org, String pass,
			String phone, String gender) throws SQLException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO User(full_name,Email_Id,Password,Contact_Number,Organisation,Gender) VALUES ('"
				+ name
				+ "','"
				+ email
				+ "','"
				+ pass
				+ "','"
				+ phone
				+ "','"
				+ org + "','" + gender + "');";

		int result = SqlConnector.executeUpdateQuery(query);
		return result;

	}

	public ResultSet loginUser(String email, String pass) throws SQLException {
		final String query = "SELECT * FROM User WHERE Password = '" + pass
				+ "' AND Email_Id = '" + email + "'";

		ResultSet rs = SqlConnector.executeQuery(query);
		System.out.println(rs);
		return rs;
	}

	public int registerVehicle(String vname, String vnumber, String empid,
			String vtype, String identy) throws SQLException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Vehicle(Name,Type,Vehicle_Number,Employee_Id,identification) VALUES ('"
				+ vname
				+ "','"
				+ vtype
				+ "','"
				+ vnumber
				+ "','"
				+ empid
				+ "','" + identy + "');";

		int result = SqlConnector.executeUpdateQuery(query);
		return result;
	}

	public ResultSet getFriendOfUser(String user) throws SQLException {
		String query2 = "Select id, full_name ,Organisation ,Email_id,Contact_number from User where Organisation IN (Select Organisation from User where ID ="
				+ Integer.parseInt(user) + ")";
		ResultSet rs = SqlConnector.executeQuery(query2);
		return rs;
	}
	
	public ResultSet  gateUserData(String userID) throws SQLException {
		final String query = "SELECT * FROM User WHERE id = '"+Integer.parseInt(userID)+"'";
		System.out.println(query);
		ResultSet rs =SqlConnector.executeQuery(query);
		return  rs;
	}
	
	public int UpdateUserData(String name, String password, String contact , String userID) throws SQLException {
		String query = "UPDATE User set  full_name = '"+name+"' , Password = '"+password+"' , Contact_number = '"+contact+"' WHERE id = '"+Integer.parseInt(userID)+"'";
		System.out.println(query);
		int result =SqlConnector.executeUpdateQuery(query);
		System.out.println(result+"dddddddddd");
		return result;
	}
	
	public int createAGatePAss(int price, int vid, int uid) throws SQLException {
		final String query = "INSERT INTO user_vehicle (price , vehicle_id , user_id) VALUES ('" + price + "','" + vid +
				"','" + uid + "');";
		System.out.println(query);
		int result =SqlConnector.executeUpdateQuery(query);
		return result;
	}
	
	public ResultSet getPriceOfVechile(String vechileType) throws SQLException {
		final String query = "SELECT * FROM Price WHERE Type = '"+vechileType+"'";
		ResultSet rs =SqlConnector.executeQuery(query);
		return  rs;

	}

	public ResultSet getVeichleDetails(String empId) throws SQLException {
		final String query = "SELECT * FROM Vehicle WHERE Employee_Id = '"+Integer.parseInt(empId)+"'";
		ResultSet rs =SqlConnector.executeQuery(query);
		return rs;
	}
}
