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
 * Servlet implementation class VehicleRegistration
 */
@WebServlet("/VehicleRegistration")
public class VehicleRegistration extends HttpServlet {
	ServiceLayer serviceLayerObj =  new ServiceLayer();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleRegistration() {
        super();
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
		ArrayList<String> error_vehicle = new ArrayList<String>();
		String vname = request.getParameter("vname");
		String vtype = request.getParameter("vehicleType");
		String vnumber = request.getParameter("number");
		String empid = request.getParameter("empid");
		String identy = request.getParameter("identy");
		
		try {
			error_vehicle = serviceLayerObj.validateVehicleData(vname, vtype, vnumber, empid,identy);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(error_vehicle == null) {

			 request.setAttribute("Success", "vinay");
			 request.getRequestDispatcher("vehicleRegister.jsp").forward(request, response);
			}
			else {
			request.setAttribute("Error", error_vehicle);
			 request.getRequestDispatcher("vehicleRegister.jsp").forward(request, response);
		}
	}
}
