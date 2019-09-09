package jdbc;

import java.sql.*;

class SqlConnector {
	String databaseName;

	/**
	 * @param dbName
	 * To set database name
	 */
	public SqlConnector(String dbName) {
		this.databaseName = dbName;
	}

	/**
	 * Function to connect with database
	 */
	public Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.databaseName, "root","root");
			return con;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * @param id
	 * @throws SQLException
	 * Given the id of a user, fetch all orders (Id, Order Date, Order Total) of that user which are in shipped state. 
	 * Orders should be sorted by order date column in chronological order.
	 */
	public void assignmentQuery1(int id) throws SQLException   {
		Connection con = createConnection();
		Statement	stmt = con.createStatement();
			// TODO Auto-generated catch block
		String query = "SELECT user.name, orders.order_id, SUM(orderitem.total) AS Total , orders.order_date , orderitem.status"
				+ " FROM  user, orders INNER JOIN orderItem on orders.order_id = orderItem.order_Id "
				+ " WHERE user.id = "
				+ id
				+ " AND orderitem.status = 'S' "
				+ " AND orders.user_id = user.id "
				+ " GROUP BY order_id"
				+ " ORDER BY order_date";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(query);
			while (rs.next())
				System.out.println(rs.getString(1) + "\t\t\t" + rs.getInt(2)
						+ "\t\t\t" + rs.getString(3) + "\t\t\t" + rs.getString(4)
						+ "\t\t\t" + rs.getString(5));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
			}
		
		}
	}

	/**
	 * @param product_id
	 * @param name
	 * @throws SQLException
	 * Insert five or more images of a product using batch insert technique.
	 */
	public void assignmentQuery2(int product_id[], String[] name) throws SQLException  {
		Connection con = createConnection();
		Statement stmt = con.createStatement();
		String query1 = "SET FOREIGN_KEY_CHECKS=0";
		String query2 = "SET FOREIGN_KEY_CHECKS=1";
		try {
			stmt.executeUpdate(query1);
			for (int i = 0; i < product_id.length; i++) {
				String query = "insert into images (product_id, name) values("
						+ product_id[i] + "," + name[i] + ")";
				stmt.addBatch(query);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.executeBatch();
			stmt.executeUpdate(query2);
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @throws SQLException
	 * Delete all those products which were not ordered by any Shopper in last 1 year. Return the number of products deleted.
	 */
	public int assignmentQuery3() throws SQLException  {
		Connection con = createConnection();
		Statement stmt = con.createStatement();
		int deletedRows = 0;
		String query1 = "set foreign_key_checks = 0;";
		try {
			stmt.executeUpdate(query1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "DELETE" + " FROM product  " + "WHERE Id " + "NOT IN"
				+ "(SELECT orderItem.product_id FROM orderItem "
				+ "INNER JOIN  orders "
				+ "ON orders.order_id = orderitem.order_id "
				+ "AND DATEDIFF(now(),orders.order_date)<60)";
		
		try {
			deletedRows = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return deletedRows;
	}

	/**
	 * @throws SQLException
	 * Select and display the category title of all top parent categories sorted alphabetically and the count of their child categories.
	 */
	public void assignmentQuery4() throws SQLException {
		Connection con = createConnection();
		Statement stmt = con.createStatement();
		String query = " SELECT count(pc.parent_Id) As Total, c.type "
				+ "FROM categories c LEFT JOIN categories pc "
				+ "ON c.id = pc.parent_id " + "GROUP BY pc.parent_Id "
				+ "ORDER BY c.type";

		ResultSet rs;
		try {
			rs = stmt.executeQuery(query);
			while (rs.next())
				System.out.println(rs.getInt(1) + "\t\t\t " + rs.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws SQLException {
		SqlConnector sq = new SqlConnector("amazon");
		 sq.assignmentQuery1(1);
		 int [] product_id ={1,3,2,3,2,1};
		 String[] name = {"'abc.jpg'","'fhh.jpg'","'fhdu.jpg'","'hfsf.jpg'","'hhf.jpg'","'hfh.jpg'"};
		 sq.assignmentQuery2(product_id, name);
		 sq.assignmentQuery3();
		 sq.assignmentQuery4();
	}
}