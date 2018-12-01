package com.covoiturage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.covoiturage.dao.DBInteraction;
import com.covoiturage.dao.DriverImpl;
import com.covoiturage.dao.IDriver;
import com.covoiturage.dao.IPassenger;
import com.covoiturage.dao.IUser;
import com.covoiturage.dao.PassengerImpl;
import com.covoiturage.dao.UserImpl;
import com.covoiturage.entities.Driver;
import com.covoiturage.entities.Passenger;
import com.covoiturage.entities.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IUser userManager;
	IDriver driverManager;
	IPassenger passengerManager;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	
    	userManager = new UserImpl();
    	driverManager = new DriverImpl();
    	passengerManager = new PassengerImpl();
    	super.init();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String password = DBInteraction.md5(request.getParameter("password"));
		String type = request.getParameter("type");
		
		User user = userManager.getUserByEmail(email);
		HttpSession session = request.getSession();
		
		if(user==null){
			user = new User(nom, prenom, email, password);
			userManager.register(user);
			user = userManager.getUserByEmail(email);
			
			if(type.equals("conducteur")){
				Driver driver = new Driver(user.getId(), 0);
				driverManager.addDriver(driver);
			}
			
			else{
				
				Passenger passenger = new Passenger(user.getId(), 0);
				passengerManager.addPassenger(passenger);
			}
			
			session.setAttribute("registerSuccess", "Congrats ! you are now a member");
			response.sendRedirect("login_2.jsp");
		}
		
		else{
			
			session.setAttribute("registerFailed", " Email address already exists");
			response.sendRedirect("login_1.jsp");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
