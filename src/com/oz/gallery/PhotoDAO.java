package com.oz.gallery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oz.list.TodoDAO;
import com.oz.main.DBManager;

public class PhotoDAO {
	
	private ArrayList<Photo> photos;
	
	private static final PhotoDAO PDAO = new PhotoDAO();

	private PhotoDAO() {

	}

	public static PhotoDAO getPdao() {
		return PDAO;
	}

	
	
	
	public void getAllPhotos(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();

			String sql = "select * from photo order by p_no";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			photos = new ArrayList<Photo>();

			Photo p = null;
			while (rs.next()) {
				// 객체 Bean필요.
				p = new Photo();
				p.setP_no(rs.getInt("p_no"));
				p.setP_title(rs.getString("p_title"));
				p.setP_img(rs.getString("p_img"));
				p.setP_date(rs.getDate("p_date"));

				photos.add(p);

			}
			request.setAttribute("photos", photos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void regPhoto(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();

			String sql = "insert into photo values (photo_seq.nextval, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);

			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);

			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 31457280, "utf-8",
					new DefaultFileRenamePolicy());

			String title = mr.getParameter("title");
			String file = mr.getFilesystemName("file");
			// 값을 잘 받고 나면 그걸 아래 물음표 채울때 쓰면 됨.

			pstmt.setString(1, title);
			pstmt.setString(2, file);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "등록 성공! ^^");
			} else {
				request.setAttribute("r", "등록 실패!!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버오류");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void showPhoto(HttpServletRequest request) {

	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      try {
	         con = DBManager.connect();

	         String sql = "select * from photo where p_no = ?";
	         pstmt = con.prepareStatement(sql);

	         int no = Integer.parseInt(request.getParameter("no"));
	         pstmt.setInt(1, no);

	         rs = pstmt.executeQuery(); // 실행

	         Photo p = null;
	         if (rs.next()) {
	            p = new Photo();
	            p.setP_no(rs.getInt("p_no"));
	            p.setP_title(rs.getString("p_title"));
	            p.setP_img(rs.getString("p_img"));
	            p.setP_date(rs.getDate("p_date"));

	         }
	         request.setAttribute("photo", p);
	         request.setAttribute("p_no", rs.getInt("p_no")); //추가 해봄 
	      } catch (Exception e) {
	         e.printStackTrace();

	      } finally {
	         DBManager.close(con, pstmt, rs);
	      }
	   }

	public void delPhoto(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();
			String sql = "delete photo where p_no = ?";
			pstmt = con.prepareStatement(sql);

			
			
			int no = Integer.parseInt(request.getParameter("no"));

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

	public void update(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();

			String sql = "update photo set p_title=?, p_img=? where p_no=?";
			pstmt = con.prepareStatement(sql);


			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);

			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 31457280, "utf-8",
					new DefaultFileRenamePolicy());
			
			
			request.setCharacterEncoding("utf-8");
			String title = mr.getParameter("title");
			String file = mr.getFilesystemName("file");
			int no = Integer.parseInt(request.getParameter("no"));

			// 값을 잘 받고 나면 그걸 아래 물음표 채울때 쓰면 됨.

			pstmt.setString(1, title);
			pstmt.setString(2, file);
			pstmt.setInt(3, no);

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

	public void paging(int page, HttpServletRequest request) {

        request.setAttribute("curPageNo", page); // 지금있는 페이지

        int cnt = 4; // 한페이지당 보여줄 개수
        int total = photos.size(); // 총 데이터 갯수
        try {
           int pageCount = (int) Math.ceil(total / (double) cnt);
           
           request.setAttribute("pageCount", pageCount); // 총 페이지
           //   5 - (4 * (1 - 1 )          
           int start = total - (cnt * (page - 1));
           
           int end = (page == pageCount) ? -1 : start - (cnt + 1);
           
           
           
           ArrayList<Photo> items = new ArrayList<Photo>();
           // 최근글이 가장 위로 올라오게 하려면 증감식도 바꾸어주어야함
           for (int i = start - 1; i > end; i--) {
              items.add(photos.get(i));
              
           }
           request.setAttribute("photos", items);
        } catch (Exception e) {
           // TODO: handle exception
           
        }
}
}