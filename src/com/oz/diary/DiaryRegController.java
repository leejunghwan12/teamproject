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
		// �̰� ����ϰ� ���� �ϳ��� �� �ؼ� ����� �������� ����ߵǴϱ� ����¡, ��ü��ȸ �� �ʿ� ����
		// �� �̰� ��ġ������ �� ���â�ߴ� ���¿���!
//		DiaryDAO.getDdao().getAllD(request);
//		DiaryDAO.getDdao().paging(1, request);
		
		DiaryDAO.getDdao().getDiary(request);
		request.setAttribute("contentPage", "Diary/DiaryDetail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
		
	
	}

}
