package com.oz.list;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.login.AccountDao;

@WebServlet("/ListController")
public class ListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		AccountDao.loginCheck(request);
		ListDAO.getSdao().getNameList(request);
		TodoDAO.getTdao().getAll(request);
		DoneDAO.getDdao().getAlldone(request);

		if (request.getAttribute("l").equals("ok")) {
			request.setAttribute("todoPage", "todo.jsp");
			request.setAttribute("donePage", "done.jsp");	
			request.setAttribute("contentPage", "todo/index.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("contentPage", "home.jsp");
			request.setAttribute("after", "after");
			response.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = response.getWriter();
			 
			out.println("<script>alert('로그인 후 이용가능합니다.'); location.href='LoginController';</script>");
			out.flush();

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      AccountDao.loginCheck(request);
	      TodoDAO.getTdao().toDone(request);
	      DoneDAO.getDdao().getAlldone(request);
	      TodoDAO.getTdao().delete(request); 
	      TodoDAO.getTdao().getAll(request); 
	      request.setAttribute("contentPage", "todo/index.jsp");
	      request.getRequestDispatcher("index.jsp").forward(request, response);
	   
	   }

	}
