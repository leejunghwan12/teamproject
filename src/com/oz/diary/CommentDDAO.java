package com.oz.diary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oz.main.DBManager;




public class CommentDDAO {

	private ArrayList<CommentD> commentlist2;
	
	private static final CommentDDAO CDAO = new CommentDDAO();

	private CommentDDAO() {

	}

	public static CommentDDAO getCdao() {
		return CDAO;
	}

	
	
	
	
	public void getAllCom(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();

			String sql = "select * from commentD order by c_no ";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			commentlist2 = new ArrayList<CommentD>();

			CommentD d = null;
			while (rs.next()) {
				// 객체 Bean필요.
			if (request.getAttribute("d_no").equals(rs.getInt("c_board"))){
				
				d = new CommentD();
				d.setC_no(rs.getInt("c_no"));
				d.setC_board(rs.getInt("c_board"));
				d.setC_id(rs.getString("c_id"));
				d.setC_text(rs.getString("c_text"));
				d.setC_rdate(rs.getDate("c_rdate"));
				
			commentlist2.add(d);
			}	
			}
				request.setAttribute("commentlist2", commentlist2);

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

			String sql = "insert into commentD values (commentD_seq.nextval, ?,?,?, sysdate)";
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
			String sql = "delete commentD where c_no = ?";
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
			String sql = "delete commentD where c_board = ?";
			pstmt = con.prepareStatement(sql);
			
			int no = 0;
			
			no = Integer.parseInt(request.getParameter("no"));

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

			String sql = "update commentD set c_text=? where c_no=?";
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
		
	