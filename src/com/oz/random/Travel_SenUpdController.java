package com.oz.random;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.login.AccountDao;


@WebServlet("/Travel_SenUpdController")
public class Travel_SenUpdController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AccountDao.loginCheck(request);
		SensibilityDAO.upd(request);
		SensibilityDAO.getSensibility(request);
		request.setAttribute("contentPage", "etc/travel.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
