package com.oz.diary;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.gallery.PhotoDAO;
import com.oz.login.AccountDao;

@WebServlet("/DiaryController")
public class DiaryController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDao.loginCheck(request);

		if (request.getAttribute("l").equals("ok")) {
			DiaryDAO.getDdao().getAllD(request);
			DiaryDAO.getDdao().paging(1, request); 
			request.setAttribute("contentPage", "Diary/Diary.jsp");
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

	}

}
