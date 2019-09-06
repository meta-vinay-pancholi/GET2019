package com.booksystem.dao;

import java.sql.*;

/**
 * This class is used to connect all database and also execute the query
 * @database
 * @author vinay
 */
public class SqlConnector {
	static Connection connectMysql() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");
			return con;
		} catch (Exception e) {
			// Handle errors for Class.forName
			System.out.println(e);
			return null;
		}

	}

	/**
	 * @param query contain the query which want to execute
	 * @return the query result
	 * @throws SQLException
	 */
	static ResultSet executeQuery(String query) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		try {
			con = connectMysql();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			ResultSet queryResult = stmt.executeQuery(query);
			con.commit();
			return queryResult;
		} catch (SQLException e) {
			System.out.println(e);
			con.rollback();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * 
	 * @param query which want to execute
	 * @return the int value
	 * @throws SQLException
	 */
	static int executeUpdateQuery(String query) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		try {
			con = connectMysql();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
			int queryResult = stmt.executeUpdate(query);
			con.commit();
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
			return queryResult;
		} catch (Exception e) {
			System.out.println(e);
			con.rollback();
		}
		return 0;
	}
}
