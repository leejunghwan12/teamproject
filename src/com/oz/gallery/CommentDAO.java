package com.oz.gallery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oz.main.DBManager;




public class CommentDAO {

	private ArrayList<Comment> commentlist;
	
	private static final CommentDAO CDAO = new CommentDAO();

	private CommentDAO() {

	}

	public static CommentDAO getCdao() {
		return CDAO;
	}

	
	
	
	
	public void getAllCom(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();

			String sql = "select * from commentG order by c_no ";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			commentlist = new ArrayList<Comment>();

			Comment c = null;
			while (rs.next()) {
				// 객체 Bean필요.
			if (request.getAttribute("p_no").equals(rs.getInt("c_board"))){
				
				c = new Comment();
				c.setC_no(rs.getInt("c_no"));
				c.setC_board(rs.getInt("c_board"));
				c.setC_id(rs.getString("c_id"));
				
				String temp = rs.getString("c_text");
				temp = temp.replace("\r\n", "<br>");
				c.setC_text(temp);
				//c.setC_text(rs.getString("c_text"));
				c.setC_rdate(rs.getDate("c_rdate"));
				
				
				
				
			commentlist.add(c);
			}	
			}
				request.setAttribute("commentlist", commentlist);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
	}

	public void regCom(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();

			String sql = "insert into commentG values (commentG_seq.nextval, ?,?,?, sysdate)";
			pstmt = con.prepareStatement(sql);

			int boardNum =  Integer.parseInt(request.getParameter("c_board"));
			String id =  request.getParameter("c_id");
			String comtext =  request.getParameter("c_text");
			

			pstmt.setInt(1, boardNum);
			pstmt.setString(2, id);
			pstmt.setString(3, comtext);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "등록 성공! ^^");
				request.setAttribute("boardNum", boardNum);
				
			} else {
				request.setAttribute("r", "등록 실패!!!!");
			}
		} catch (Exception e) {

		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void delCom(HttpServletRequest request) {
	
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();
			String sql = "delete commentG where c_no = ?";
			pstmt = con.prepareStatement(sql);
			
			int no = 0;
			
			no = Integer.parseInt(request.getParameter("no2"));

			pstmt.setInt(1, no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제성공");
			} else {
				request.setAttribute("r", "삭제실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버오류");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void delCom2(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();
			String sql = "delete commentG where c_board = ?";
			pstmt = con.prepareStatement(sql);
			
			
			int no = Integer.parseInt(request.getParameter("no"));

			pstmt.setInt(1, no);

			if (pstmt.executeUpdate() >= 1) {
				request.setAttribute("r", "삭제성공");
			} else {
				request.setAttribute("r", "삭제실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버오류");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
	
	
	public void updCom(HttpServletRequest request) {


		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();

			String sql = "update commentG set c_text=? where c_no=?";
			pstmt = con.prepareStatement(sql);

			int no = 0; 
			
			String text = request.getParameter("text");
			no = Integer.parseInt(request.getParameter("no2"));

			// 값을 잘 받고 나면 그걸 아래 물음표 채울때 쓰면 됨.

			pstmt.setString(1, text);
			pstmt.setInt(2, no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "업데이트 성공! ^^");
			} else {
				request.setAttribute("r", "업데이트 실패!!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버오류");
		} finally {
			DBManager.close(con, pstmt, null);
		}

		
		
		
		
	}
 
		
	
	
	
}
		
	