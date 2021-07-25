package com.oz.diary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oz.main.DBManager;

public class DiaryDAO {

	private ArrayList<Diary> diarys;

	private static final DiaryDAO DDAO = new DiaryDAO();

	public DiaryDAO() {
	}

	public static DiaryDAO getDdao() {
		return DDAO;
	}

	public void regD(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = DBManager.connect();
			String sql = "insert into diary values(diary_seq.nextval, ?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);

			String sD = request.getServletContext().getRealPath("img");
			System.out.println(sD);

			MultipartRequest mr = new MultipartRequest(request, sD, 31457280, "utf-8", new DefaultFileRenamePolicy());
			String writer = mr.getParameter("writer");
			String title = mr.getParameter("title");
			String story = mr.getParameter("story");
			story = story.replace("\r\n", "<br>");
			String fName = mr.getFilesystemName("file");
			// String name = request.getSession().getAttribute("세션설정된이름")

			pstmt.setString(1, title);
			pstmt.setString(2, story);
			pstmt.setString(3, fName);
			pstmt.setString(4, writer); 

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "등록 성공!");
				// 등록을 성공하면? 그 넘버로 조회한 no를 챙길 생각을
				// 등록하면 seq가 제일 큰걸 가져오면 되겠네요 어차피 계속 올라가니까? ㅎ 아하
				pstmt.close();
				sql = "select max(d_no) as d_max from diary";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					request.setAttribute("d_no", rs.getString("d_max"));
				}

			} else {
				request.setAttribute("r", "등록 실패!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB서버 오류");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void getAllD(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 작업 뭐 하려면 일단 연결
			con = DBManager.connect();

			String sql = "select * from Diary order by d_no";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();// 위에 준비된 저 sql을 실행. R이 있으면 쿼리
			// 처음부터 끝까지 봐야하니까
			diarys = new ArrayList<Diary>();
			Diary d = null;
			while (rs.next()) {

				// 객체만들 생각(묶어서 보내려고)

				d = new Diary();
				d.setD_no(rs.getInt("d_no"));
				d.setD_title(rs.getString("d_title"));
//				System.out.println(rs.getString("d_date"));
				d.setD_date(rs.getDate("d_date"));
				d.setD_writer(rs.getString("d_writer"));
				diarys.add(d);
			}
			request.setAttribute("diarys", diarys);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 다 쓰고나면 잘 닫아야
			DBManager.close(con, pstmt, rs);
		}

	}

	public void getDiary(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		// CRUD 중 R할때 (Read) 조회할때 select * from할때
		ResultSet rs = null;

		try {

			con = DBManager.connect();

			// 이제 여기서 등록을 하고 난 다음 그 d_no를 가져와야되는데
			// 클릭해서 넘어가고 이런게 아니니까 이 값이 없는 상태죠 지금. 그쵸 못받아오더라구요
			// 저걸 어떻게 받아낼까를 생각해야되는데
			// ?
			String sql = "select * from Diary where d_no=? ";
			pstmt = con.prepareStatement(sql);

			String no = request.getParameter("no");
			System.out.println(no);
			if (no == null) {
				no = (String) request.getAttribute("d_no");
			}
			pstmt.setString(1, no);

			rs = pstmt.executeQuery();
			Diary d = null;

			// 이건 무조건 true 존재하는 영화의 수정버튼을 눌렀기때문에
			if (rs.next()) {
				d = new Diary();
				d.setD_no(rs.getInt("d_no"));
				d.setD_title(rs.getString("d_title"));
				d.setD_story(rs.getString("d_story"));
				d.setD_writer(rs.getString("d_writer"));
				/*
				 * String temp = rs.getString("d_story"); temp = temp.replace("<br>", "\r\n");
				 * d.setD_story(temp);
				 */
				d.setD_img(rs.getString("d_img"));
				d.setD_date(rs.getDate("d_date"));
			}
			// 이건 값을 받았을때 조회가 되고나면 만들어지는 다이어리 객체.

			request.setAttribute("d", d);
			request.setAttribute("d_no", rs.getInt("d_no"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	public void getDiary2(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		// CRUD 중 R할때 (Read) 조회할때 select * from할때
		ResultSet rs = null;
		
		try {
			
			con = DBManager.connect();
			
			// 이제 여기서 등록을 하고 난 다음 그 d_no를 가져와야되는데
			// 클릭해서 넘어가고 이런게 아니니까 이 값이 없는 상태죠 지금. 그쵸 못받아오더라구요
			// 저걸 어떻게 받아낼까를 생각해야되는데
			// ?
			String sql = "select * from Diary where d_no=? ";
			pstmt = con.prepareStatement(sql);
			
			String no = request.getParameter("no");
			System.out.println(no);
			if (no == null) {
				no = (String) request.getAttribute("d_no");
			}
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			Diary d = null;
			
			// 이건 무조건 true 존재하는 영화의 수정버튼을 눌렀기때문에
			if (rs.next()) {
				d = new Diary();
				d.setD_no(rs.getInt("d_no"));
				d.setD_title(rs.getString("d_title"));
				String temp = rs.getString("d_story"); temp = temp.replace("<br>", "\r\n");
				d.setD_story(temp);
				d.setD_img(rs.getString("d_img"));
				d.setD_date(rs.getDate("d_date"));
			}
			// 이건 값을 받았을때 조회가 되고나면 만들어지는 다이어리 객체.
			
			request.setAttribute("d", d);
			request.setAttribute("d_no", rs.getInt("d_no"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void DiaryDel(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();
			String sql = "delete Diary where d_no = ?";
			pstmt = con.prepareStatement(sql);

			int no = Integer.parseInt(request.getParameter("no"));
			pstmt.setInt(1, no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제 성공!");
			} else {
				request.setAttribute("r", "삭제 실패!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버 오류!");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void updateDiary(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DBManager.connect();
			String sql = "update Diary " + "set d_title=? , d_story=?, d_img=? " + "where d_no =?";

			pstmt = con.prepareStatement(sql);

			String sD = request.getServletContext().getRealPath("img");
			System.out.println(sD);

			MultipartRequest mr = new MultipartRequest(request, sD, 31457280, "utf-8", new DefaultFileRenamePolicy());

			String title = mr.getParameter("title");
			System.out.println(title);
			String story = mr.getParameter("story");
			System.out.println(story);
			story = story.replace("\r\n", "<br>");
			String img = mr.getFilesystemName("file");
			System.out.println(img);
			if (img == null) {
				System.out.println(111);
				img = mr.getParameter("file2");
				System.out.println(img);
			}
			// 선택을 안하면 당연히 null,
			// 기존의 파일명을 동일하게 ?에 넣어주면..
			int no = Integer.parseInt(mr.getParameter("no"));
			System.out.println(no);

			
			
				pstmt.setString(1, title);
				pstmt.setString(2, story);
				pstmt.setString(3, img);
				pstmt.setInt(4, no);

				if (pstmt.executeUpdate() == 1) {
					request.setAttribute("r", "수정완료~");
					if (pstmt.executeUpdate() == 1) {
						request.setAttribute("r", "수정완료~");
						pstmt.close();
						sql ="select*from Diary where d_no="+no;
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();
						if (rs.next()) {
						request.setAttribute("d_no", rs.getString("d_no"));
						}
				} else {
					request.setAttribute("r", "수정 실패ㅜㅜ");
				}
			}
		 }catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB오류");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void paging(int page, HttpServletRequest request) {
		request.setAttribute("curPageNo", page);

		// 전체 페이지 수 계산
		int cnt = 10; // 한페이지당 보여줄 개수
		int total = diarys.size(); // 총 데이터 개수

		try {

			int pageCount = (int) Math.ceil(total / (double) cnt);
			request.setAttribute("pageCount", pageCount);

			int start = total - (cnt * (page - 1));

			int end = (page == pageCount) ? -1 : start - (cnt + 1);

			ArrayList<Diary> items = new ArrayList<Diary>();

			for (int i = start - 1; i > end; i--) {
				items.add(diarys.get(i));
			}

			request.setAttribute("diarys", items);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
