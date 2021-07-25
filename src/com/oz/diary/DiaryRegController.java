package com.oz.diary;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.login.AccountDao;


@WebServlet("/DiaryRegController")
public class DiaryRegController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AccountDao.loginCheck(request);

		request.setAttribute("contentPage", "Diary/DiaryReg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AccountDao.loginCheck(request);

		DiaryDAO.getDdao().regD(request);
		// 이게 등록하고 나서 하나를 겟 해서 등록한 페이지를 띄워야되니까 페이징, 전체조회 다 필요 없죠
		// 네 이건 고치기전에 그 목록창뜨는 상태예요!
//		DiaryDAO.getDdao().getAllD(request);
//		DiaryDAO.getDdao().paging(1, request);
		
		DiaryDAO.getDdao().getDiary(request);
		request.setAttribute("contentPage", "Diary/DiaryDetail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
		
	
	}

}
