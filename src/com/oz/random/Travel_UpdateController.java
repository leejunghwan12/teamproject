package com.oz.random;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.login.AccountDao;


@WebServlet("/Travel_UpdateController")
public class Travel_UpdateController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AccountDao.loginCheck(request);
		request.setAttribute("contentPage", "etc/travelUpdate.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

}
