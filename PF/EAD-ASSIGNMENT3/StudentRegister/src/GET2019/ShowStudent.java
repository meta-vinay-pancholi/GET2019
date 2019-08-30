package GET2019;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ShowStudent
 */
@WebServlet("/ShowStudent")
public class ShowStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int count = 0;
		if(request.getParameter("id")==null){
			try {

				// loading drivers for mysql
				Class.forName("com.mysql.jdbc.Driver");

				// creating connection with the database
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/Student", "root", "root");

				PreparedStatement ps = (PreparedStatement) con
						.prepareStatement("Select * from Student_details");

				ResultSet rs = ps.executeQuery();

				out.println("<table align='center' cellspacing ='30'> " + "<tr> "
						+ "<th>Id</th>" + "<th>Name</th>" + "<th>Father Name</th>"
						+ "<th>Email</th>" + "<th>Class</th>"
						+ "<th>Age</th>" + "</tr>" + "</table>");
				while (rs.next()) {
					 count = 1;
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
							+"<td>" +"<a href=ShowStudent?id="+rs.getInt(1)+"> Update </a>"+"</td>" +"</tr>" + "</table>");
				}

			} catch (Exception se) {
				se.printStackTrace();
			}
		} else {
			
			
			try {
				out.println("<h1 align=center >Update data</h1>");
				// loading drivers for mysql
				Class.forName("com.mysql.jdbc.Driver");

				// creating connection with the database
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/Student", "root", "root");
				String id = request.getParameter("id");
				PreparedStatement ps = (PreparedStatement) con
						.prepareStatement("Select * from Student_details WHERE id = ?");
				ps.setString(1,id);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					 count = 1;
					out.println("<form method='post' action='ShowStudent'> "
							+ "<input type=number name=id value = "
							+ rs.getInt(1)+">"
							+ "<input type=text name=firstname value = "
							+ rs.getString(2)+">"
							+ "<input type=text name=lastname value = "
							+ rs.getString(3)+">"
							+ "<input type=text name=fathername value = "
							+ rs.getString(4) +">"
							+ "<input type=text name=email value = "
							+ rs.getString(5)+">"
							+ "<input type=number name=classOfStudent value = "
							+ rs.getInt(6)+">"
							+ "<input type=number name=age value = "
							+ rs.getInt(7)+">"
							+"<input type=submit value = UpdateStudent />"
							+"</form>");
				}

			} catch (Exception se) {
				se.printStackTrace();
			}
			
			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   response.setContentType("text/html;charset=UTF-8");
	       PrintWriter out = response.getWriter();
	       int id = Integer.parseInt(request.getParameter("id"));
	       String firstname = request.getParameter("firstname");
	       String lastname = request.getParameter("lastname");
	       String fathername = request.getParameter("fathername");
	       String email = request.getParameter("email");
	       int classOfstudent = Integer.parseInt(request.getParameter("classOfStudent"));
	       int age = Integer.parseInt(request.getParameter("age"));
	       try {
	       
	           // loading drivers for mysql
	           Class.forName("com.mysql.jdbc.Driver");
	           
	           //creating connection with the database 
	           Connection con = DriverManager.getConnection
	                       ("jdbc:mysql://localhost:3306/Student","root","root");

	           PreparedStatement ps = (PreparedStatement) con.prepareStatement
	                       ("Update  student_details SET first_name = ?, last_name = ?, father_name = ?, email = ?, class = ?, age = ? where id = ?");

	           ps.setString(1, firstname);
	           ps.setString(2, lastname);
	           ps.setString(3, fathername);
	           ps.setString(4, email);
	           ps.setInt(5, classOfstudent);
	           ps.setInt(6, age );
	           ps.setInt(7,id);
	           ps.executeUpdate();

	           String site = new String("http://localhost:8080/StudentRegister/ShowStudent");
	           response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
	           response.setHeader("Location", site); 
	       }
	       catch(Exception se) {
	           se.printStackTrace();
	       }
		
	   }
	}

