package com.metaparking.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metaparking.dao.DaoLayer;
import com.metaparking.service.ServiceLayer;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	DaoLayer DaoLayerObj = new DaoLayer();
	ServiceLayer ServiceLayerObj = new ServiceLayer();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
		DaoLayer dao = new DaoLayer();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String email = request.getParameter("Email");
		String pass = request.getParameter("Password");
		int check = 0;
		try {
			ResultSet userData = ServiceLayerObj.authenticateUser(pass,
					email);
			while (userData.next()) {
				check = 1;
				HttpSession session = request.getSession(true);
				session.setAttribute("user", userData.getInt("id"));
				
			}
			if (check == 0) {
				request.setAttribute("AuthenicationFailed",
						"Please Enter Valid Details");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			} else {
				response.sendRedirect("vehicleRegister.jsp");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
