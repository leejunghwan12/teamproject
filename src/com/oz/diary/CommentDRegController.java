package com.oz.diary;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.login.AccountDao;

/**
 * Servlet implementation class CommentController
 */
@WebServlet("/CommentDRegController")
public class CommentDRegController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AccountDao.loginCheck(request);
		DiaryDAO.getDdao().getDiary(request);
		CommentDDAO.getCdao().regCom(request);
		CommentDDAO.getCdao().getAllCom(request);
		request.setAttribute("contentPage", "Diary/DiaryDetail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
