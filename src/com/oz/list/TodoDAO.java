package com.oz.list;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oz.main.DBManager;




public class TodoDAO {
	
	private ArrayList<Todo> todolist;
	private static final TodoDAO TDAO = new TodoDAO();
	
	private TodoDAO() {
	}
	
	public static TodoDAO getTdao() {
		return TDAO;
	}

	public void getAllName(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();
			String sql = "select * from join order by t_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
		   todolist = new ArrayList<Todo>();
			Todo t = null;
			//rs.next 있으면 트루 없으면 false 
			while (rs.next()) {
				
				
			 t = new Todo();
				t.setT_no(rs.getInt("t_no"));
				t.setT_title(rs.getString("t_title"));
				t.setT_priority(rs.getString("t_priority"));
				t.setT_names(rs.getString("t_names"));
				todolist.add(t);
				
			}
			
			request.setAttribute("todolist", todolist);
			request.setAttribute("todoPage", "todo.jsp");
			request.setAttribute("donePage", "done.jsp");
			
		} catch (Exception e) {

		}finally {
			
			DBManager.close(con, pstmt, rs);
			
		}		
	
		
		
	}
	
	
	public void reg(HttpServletRequest request) throws UnsupportedEncodingException {


		Connection con = null;	
		PreparedStatement pstmt = null;
		
		request.setCharacterEncoding("utf-8");

		 String todo =  request.getParameter("todo");
		 int priority	= Integer.parseInt(request.getParameter("priority"));
		 String []who = request.getParameterValues("who");
		 
		 String names = who[0];
			 
		 if (who!=null) {
			 for (int i = 1; i < who.length; i++) {
				 names += ", "+ who[i] ;
			}
		}
		
		 
		
		 //여기서 이 who를 set어트리뷰트를 해주면 뭔가 될것같다. //세션아이디 이용하자.  
//		for (String who2 : who) {
//			if (who2== ) {
//				
//			}
//		
//		}
		
		try {

		con = DBManager.connect();
		
		String sql = "insert into todo values (todo_seq.nextval,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, todo);	
		pstmt.setInt(2, priority);	
		pstmt.setString(3, names);	
		
		
		
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

	public  void getAll(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		
		try {
		
			con = DBManager.connect();
			
			String sql = "select * from todo order by t_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
		   todolist = new ArrayList<Todo>();
			Todo t = null;
			//rs.next 있으면 트루 없으면 false 
			while (rs.next()) {
				
				
			 t = new Todo();
				t.setT_no(rs.getInt("t_no"));
				t.setT_title(rs.getString("t_title"));
				t.setT_priority(rs.getString("t_priority"));
				t.setT_names(rs.getString("t_names"));
				todolist.add(t);
				
			}
			
			request.setAttribute("todolist", todolist);
			request.setAttribute("todoPage", "todo.jsp");
			request.setAttribute("donePage", "done.jsp");
			
		} catch (Exception e) {

		}finally {
			
			DBManager.close(con, pstmt, rs);
			
		}		
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
	

	public void delete(HttpServletRequest request) {


		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "delete todo where t_no = ?";
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



	public void getAlldone(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		
		try {
		
			con = DBManager.connect();
			
			String sql = "select * from done";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
		   ArrayList<Done> donelist = new ArrayList<Done>();
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
	
				
		
		
		
		
	}


