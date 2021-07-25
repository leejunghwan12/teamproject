package com.oz.gallery;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.login.AccountDao;

@WebServlet("/GalleryDetailController")
public class GalleryDetailController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDao.loginCheck(request);
		PhotoDAO.getPdao().showPhoto(request);
		CommentDAO.getCdao().regCom(request);
		CommentDAO.getCdao().getAllCom(request);
		request.setAttribute("contentPage", "gallery/gallery_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
	
	}

}
