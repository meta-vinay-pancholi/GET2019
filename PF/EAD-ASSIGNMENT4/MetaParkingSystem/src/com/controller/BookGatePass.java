package com.metaparking.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.metaparking.service.ServiceLayer;

/**
 * Servlet implementation class BookGetPass
 */
@WebServlet("/BookGatePass")
public class BookGatePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceLayer serviceLayerObj;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookGatePass() {
        super();
    	this.serviceLayerObj = new ServiceLayer();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vehcileId = request.getParameter("id");
		String vechileType = request.getParameter("vtype");
		boolean result = serviceLayerObj.validateVehicleData(vehcileId,vechileType);
		if(result){
			 try {
				 HttpSession session = request.getSession(true);
				 session.setAttribute("vId", vehcileId);
				 request.setAttribute("priceOfVechile",serviceLayerObj.getPriceOfVehicle(vechileType));
				 request.getRequestDispatcher("bookGatePass.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("sss");
			response.sendRedirect("http://localhost:8080/MetaparkingSystem/gatepass.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}