package com.oz.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.diary.DiaryDAO;
import com.oz.login.AccountDao;

@WebServlet("/MypageController")
public class MypageController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AccountDao.loginCheck(request);

		
			JoinDAO.getSdao().getInfo(request);	
			
			request.setAttribute("contentPage", "join/info.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		AccountDao.loginCheck(request);

		JoinDAO.getSdao().getInfo(request);
		
		request.setAttribute("contentPage", "join/infoChange.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);

	
	}

}
