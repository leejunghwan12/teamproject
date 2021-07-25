package com.oz.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/LoginController")
public class LoginController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AccountDao.loginCheck(request);
		request.setAttribute("contentPage", "login/login.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		AccountDao.login(request);
		AccountDao.loginCheck(request);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

}
