package com.oz.plan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.login.AccountDao;

@WebServlet("/PlanRegController")
public class PlanRegController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDao.loginCheck(request);

		PlanDAO.cal(request);
		PlanDAO.getPdao().regPlan(request, response);
		PlanDAO.getPdao().showAllPlan(request);
		PlanDAO.getPdao().divideDate(request);
		request.setAttribute("contentPage", "plan/month.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	
	}

}
