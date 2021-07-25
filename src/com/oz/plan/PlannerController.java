package com.oz.plan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.login.AccountDao;

@WebServlet("/PlannerController")
public class PlannerController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AccountDao.loginCheck(request);

		if (request.getAttribute("l").equals("ok")) {
			PlanDAO.getPdao().showAllPlan(request); //���� �����ְ� �Ķ���Ͱ� �ѱ�� ��ŸƮ�� ���嵥�̸� �ѱ���
			PlanDAO.getPdao().divideDate(request); // �װ� ���� ? �ڸ��� �ڸ��� ������ش� 
			PlanDAO.cal(request); //�׸��� �޷°����� �޾ƿ´�. 
			request.setAttribute("contentPage", "plan/month.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("contentPage", "home.jsp");
			request.setAttribute("after", "after");
			response.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = response.getWriter();
			 
			out.println("<script>alert('�α��� �� �̿밡���մϴ�.'); location.href='LoginController';</script>");
			out.flush();

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
