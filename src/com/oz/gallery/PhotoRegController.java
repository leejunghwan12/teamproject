package com.oz.gallery;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.login.AccountDao;


@WebServlet("/PhotoRegController")
public class PhotoRegController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDao.loginCheck(request);
		PhotoDAO.getPdao().regPhoto(request);
		PhotoDAO.getPdao().getAllPhotos(request);
		PhotoDAO.getPdao().paging(1, request);
		
		request.setAttribute("contentPage", "gallery/gallery.jsp");
	request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	}

}
