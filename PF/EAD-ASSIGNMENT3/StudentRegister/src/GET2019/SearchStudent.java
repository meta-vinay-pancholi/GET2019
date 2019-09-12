package GET2019;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class SearchStudent
 */
@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String firstname = request.getParameter("firstname");
		try {

			// loading drivers for mysql
			Class.forName("com.mysql.jdbc.Driver");

			// creating connection with the database
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Student", "root", "root");

			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT * FROM student_details WHERE first_name = ?");
			  ps.setString(1, firstname);  
			ResultSet rs = ps.executeQuery();

			out.println("<table align='center' cellspacing ='30'> " + "<tr> "
					+ "<th>Id</th>" + "<th>Name</th>" + "<th>FatherName</th>"
					+ "<th>Email</th>" + "<th>Age</th>"
					+ "<th>Class</th>" + "</tr>" + "</table>");
			while (rs.next()) {
				out.println("<table  align='center' cellspacing ='30'> "
						+ "<tr> "
						+ "<td>"
						+ rs.getInt(1)
						+ "</td>"
						+ "<td>"
						+ rs.getString(2)+" "
						+ rs.getString(3)
						+ "</td>"
						+ "<td>"
						+ rs.getString(4)
						+ "</td>"
						+ "<td>"
						+ rs.getString(5)
						+ "</td>"
						+ "<td>"
						+ rs.getInt(6) + "</td>" 
						+ "<td>"
						+ rs.getInt(7) + "</td>" 
						+"</tr>" + "</table>");
			}
	
		}

		catch (Exception se) {
			se.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String classofstudent = request.getParameter("classofstudent");
		try {

			// loading drivers for mysql
			Class.forName("com.mysql.jdbc.Driver");

			// creating connection with the database
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Student", "root", "root");

			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT * FROM student_details WHERE class = ?");
			  ps.setString(1, classofstudent);  
			ResultSet rs = ps.executeQuery();

			out.println("<table align='center' cellspacing ='30'> " + "<tr> "
					+ "<th>Id</th>" + "<th>Name</th>" + "<th>FatherName</th>"
					+ "<th>Email</th>" + "<th>Class</th>"
					+ "<th>Age</th>" + "</tr>" + "</table>");
			while (rs.next()) {
				out.println("<table  align='center' cellspacing ='30'> "
						+ "<tr> "
						+ "<td>"
						+ rs.getInt(1)
						+ "</td>"
						+ "<td>"
						+ rs.getString(2)+" "
						+ rs.getString(3)
						+ "</td>"
						+ "<td>"
						+ rs.getString(4)
						+ "</td>"
						+ "<td>"
						+ rs.getString(5)
						+ "</td>"
						+ "<td>"
						+ rs.getInt(6) + "</td>" 
						+ "<td>"
						+ rs.getInt(7) + "</td>" 
						+"</tr>" + "</table>");
			}
	
		}

		catch (Exception se) {
			se.printStackTrace();
		}
	}
}
