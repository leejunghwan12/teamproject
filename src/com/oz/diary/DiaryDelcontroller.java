package com.oz.diary;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.login.AccountDao;

@WebServlet("/DiaryDelcontroller")
public class DiaryDelcontroller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AccountDao.loginCheck(request);

		DiaryDAO.getDdao().DiaryDel(request);
		CommentDDAO.getCdao().delCom2(request);
		DiaryDAO.getDdao().getAllD(request);
		DiaryDAO.getDdao().paging(1, request);
		request.setAttribute("contentPage", "Diary/Diary.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
