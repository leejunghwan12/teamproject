package com.oz.gallery;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oz.login.AccountDao;


@WebServlet("/PhotoDelController")
public class PhotoDelController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AccountDao.loginCheck(request);
		PhotoDAO.getPdao().delPhoto(request);
		CommentDAO.getCdao().delCom2(request);
		PhotoDAO.getPdao().getAllPhotos(request);
		PhotoDAO.getPdao().paging(1, request);
		
		request.setAttribute("contentPage", "gallery/gallery.jsp");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
