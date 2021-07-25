package com.oz.gallery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.login.AccountDao;

@WebServlet("/GalleryController")
public class GalleryController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	AccountDao.loginCheck(request);


	if (request.getAttribute("l").equals("ok")) {
		PhotoDAO.getPdao().getAllPhotos(request);
		PhotoDAO.getPdao().paging(1, request);
		request.setAttribute("contentPage", "gallery/gallery.jsp");
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
