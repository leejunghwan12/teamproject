package com.oz.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.login.AccountDao;

@WebServlet("/ChangeInfoController")
public class ChangeInfoController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AccountDao.loginCheck(request);

		JoinDAO.getSdao().getInfo(request);
		JoinDAO.getSdao().dividePN(request);
		request.setAttribute("contentPage", "join/infoChange.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		AccountDao.loginCheck(request);

		JoinDAO.getSdao().getInfo(request);
		JoinDAO.getSdao().dividePN(request);
		JoinDAO.getSdao().change(request);

		PrintWriter out = response.getWriter();
		 
		out.println("<script>alert('Complete'); location.href='HC';</script>");
		//out.flush();
		
		

	}

}
