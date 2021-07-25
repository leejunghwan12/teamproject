package com.oz.gallery;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.gallery.PhotoDAO;
import com.oz.login.AccountDao;

@WebServlet("/GalleryPageController")
public class GalleryPageController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDao.loginCheck(request);
		int p = Integer.parseInt(request.getParameter("p"));
		PhotoDAO.getPdao().paging(p, request);
		request.setAttribute("contentPage", "gallery/gallery.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
