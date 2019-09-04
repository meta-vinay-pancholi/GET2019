package com.metaparking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metaparking.service.ServiceLayer;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceLayer ServiceLayerObj;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistration() {
		super();
		this.ServiceLayerObj= new ServiceLayer();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (request.getParameter("submit") == null) {
			request.setAttribute("message", "Please Submit the form");
			request.getRequestDispatcher("./index.jsp").forward(request,
					response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> errors = new ArrayList<String>();
		String name = request.getParameter("Name");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("Contact");
		String email = request.getParameter("Email");
		String org = request.getParameter("org_type");
		String pass = request.getParameter("Password");
		String conpass = request.getParameter("Conpassword");

		try {
			errors = ServiceLayerObj.validateUserData(name, gender, phone, email,
					org, pass, conpass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(errors == null) {

			 request.setAttribute("Success", "vinay");
			 request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else {
			request.setAttribute("Error", errors);
			 request.getRequestDispatcher("index.jsp").forward(request, response);

			}

	}

}
