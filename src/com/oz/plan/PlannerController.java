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
			PlanDAO.getPdao().showAllPlan(request); //전부 보여주고 파라메터값 넘긴다 스타트랑 엔드데이만 넘기면됨
			PlanDAO.getPdao().divideDate(request); // 그걸 전부 ? 자른다 자르고 등록해준다 
			PlanDAO.cal(request); //그리고 달력값들을 받아온다. 
			request.setAttribute("contentPage", "plan/month.jsp");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
