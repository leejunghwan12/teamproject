package com.oz.list;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.login.AccountDao;

@WebServlet("/TodoDelController")
public class TodoDelController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AccountDao.loginCheck(request);
		TodoDAO.getTdao().delete(request);
		TodoDAO.getTdao().getAll(request);
		DoneDAO.getDdao().getAlldone(request);
		request.setAttribute("contentPage", "todo/index.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
	}

}
