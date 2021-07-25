package com.oz.list;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oz.main.DBManager;

public class DoneDAO {
	
	private ArrayList<Done> donelist;
	private static final DoneDAO DDAO = new DoneDAO();
	
	public DoneDAO() {
		// TODO Auto-generated constructor stub
	}

	public static DoneDAO getDdao() {
		return DDAO;
	}
	
	
	public void toDone(HttpServletRequest request) throws UnsupportedEncodingException {

		Connection con = null;	
		PreparedStatement pstmt = null;
		
		request.setCharacterEncoding("utf-8");

		 String title =  request.getParameter("title");
		 String names =  request.getParameter("names");
		 int priority	= Integer.parseInt(request.getParameter("prior"));
		 int no	= Integer.parseInt(request.getParameter("no"));


		try {

		con = DBManager.connect();
		String sql = "insert into done values (?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);	
		pstmt.setString(2, title);	
		pstmt.setInt(3, priority);	
		pstmt.setString(4, names);	
		
		
		
		if (pstmt.executeUpdate()==1) {
			request.setAttribute("r", "등록성공!");
		}else {
			request.setAttribute("r", "등록실패!!!");
			
		}
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버오류 !!!");
		}finally {
			DBManager.close(con, pstmt, null);
			
		}
		
	}
	
	public void getAlldone(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		
		try {
		
			con = DBManager.connect();
			
			String sql = "select * from done order by d_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
		   donelist = new ArrayList<Done>();
			Done d = null;
			//rs.next 있으면 트루 없으면 false 
			while (rs.next()) {
				
				
			 d = new Done();
			 	d.setD_no(rs.getInt("d_no"));
			 	d.setD_title(rs.getString("d_title"));
			 	d.setD_priority(rs.getInt("d_priority"));
			 	d.setD_names(rs.getString("d_names"));
			 	
			 	donelist.add(d);
				
			}
			
			request.setAttribute("donelist", donelist);
		
		} catch (Exception e) {

		}finally {
			
			DBManager.close(con, pstmt, rs);
			
		}		
	
		
	}

	public void delete(HttpServletRequest request) {


		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "delete done where d_no = ?";
			pstmt = con.prepareStatement(sql);
			
			int no = Integer.parseInt(request.getParameter("no"));
			
			pstmt.setInt(1, no);
			
			
			
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제 성공!");
			}else {
				request.setAttribute("r", "삭제 실패!");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB서버 오류!");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		

		
		
	}

	

}
