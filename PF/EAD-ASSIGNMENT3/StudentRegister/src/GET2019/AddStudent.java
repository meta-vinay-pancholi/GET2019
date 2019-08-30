package GET2019;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddStudent() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
	
       String firstname = request.getParameter("firstname");
       String lastname = request.getParameter("lastname");
       String fathername = request.getParameter("fathername");
       String email = request.getParameter("email");
       String classOfstudent = request.getParameter("classOfstudent");
       String age = request.getParameter("age");
       try {
       
           // loading drivers for mysql
           Class.forName("com.mysql.jdbc.Driver");
           
           //creating connection with the database 
           Connection con = DriverManager.getConnection
                       ("jdbc:mysql://localhost:3306/Student","root","root");

           PreparedStatement ps = (PreparedStatement) con.prepareStatement
                       ("insert into Student_details (first_name,last_name,father_name,email,class,age)  values(?,?,?,?,?,?)");

           ps.setString(1, firstname);
           ps.setString(2, lastname);
           ps.setString(3, fathername);
           ps.setString(4, email);
           ps.setString(5, classOfstudent );
           ps.setString(6, age);
          
           int i = ps.executeUpdate();
           
           if(i > 0) {
               out.println("You are sucessfully registered");
               String site = new String("http://localhost:8080/StudentRegister/index.html");
	           response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
	           response.setHeader("Location", site); 
           }
       
       }
       catch(Exception se) {
           se.printStackTrace();
       }
	
   }
}


