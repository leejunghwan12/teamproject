package com.oz.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.oz.login.AccountDao;

@WebServlet("/RedubController")
public class RedubController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("join/idCheck.jsp").forward(request, response);
		}
		JoinDAO.getSdao().redub(request);
		request.getRequestDispatcher("join/idCheck.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
