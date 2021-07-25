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
			// String name = request.getSession().getAttribute("���Ǽ������̸�")

			pstmt.setString(1, title);
			pstmt.setString(2, story);
			pstmt.setString(3, fName);
			pstmt.setString(4, writer); 

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "��� ����!");
				// ����� �����ϸ�? �� �ѹ��� ��ȸ�� no�� ì�� ������
				// ����ϸ� seq�� ���� ū�� �������� �ǰڳ׿� ������ ��� �ö󰡴ϱ�? �� ����
				pstmt.close();
				sql = "select max(d_no) as d_max from diary";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					request.setAttribute("d_no", rs.getString("d_max"));
				}

			} else {
				request.setAttribute("r", "��� ����!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB���� ����");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void getAllD(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// �۾� �� �Ϸ��� �ϴ� ����
			con = DBManager.connect();

			String sql = "select * from Diary order by d_no";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();// ���� �غ�� �� sql�� ����. R�� ������ ����
			// ó������ ������ �����ϴϱ�
			diarys = new ArrayList<Diary>();
			Diary d = null;
			while (rs.next()) {

				// ��ü���� ����(��� ��������)

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
			// �� ������ �� �ݾƾ�
			DBManager.close(con, pstmt, rs);
		}

	}

	public void getDiary(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		// CRUD �� R�Ҷ� (Read) ��ȸ�Ҷ� select * from�Ҷ�
		ResultSet rs = null;

		try {

			con = DBManager.connect();

			// ���� ���⼭ ����� �ϰ� �� ���� �� d_no�� �����;ߵǴµ�
			// Ŭ���ؼ� �Ѿ�� �̷��� �ƴϴϱ� �� ���� ���� ������ ����. ���� ���޾ƿ����󱸿�
			// ���� ��� �޾Ƴ�� �����ؾߵǴµ�
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

			// �̰� ������ true �����ϴ� ��ȭ�� ������ư�� �����⶧����
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
			// �̰� ���� �޾����� ��ȸ�� �ǰ��� ��������� ���̾ ��ü.

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
		// CRUD �� R�Ҷ� (Read) ��ȸ�Ҷ� select * from�Ҷ�
		ResultSet rs = null;
		
		try {
			
			con = DBManager.connect();
			
			// ���� ���⼭ ����� �ϰ� �� ���� �� d_no�� �����;ߵǴµ�
			// Ŭ���ؼ� �Ѿ�� �̷��� �ƴϴϱ� �� ���� ���� ������ ����. ���� ���޾ƿ����󱸿�
			// ���� ��� �޾Ƴ�� �����ؾߵǴµ�
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
			
			// �̰� ������ true �����ϴ� ��ȭ�� ������ư�� �����⶧����
			if (rs.next()) {
				d = new Diary();
				d.setD_no(rs.getInt("d_no"));
				d.setD_title(rs.getString("d_title"));
				String temp = rs.getString("d_story"); temp = temp.replace("<br>", "\r\n");
				d.setD_story(temp);
				d.setD_img(rs.getString("d_img"));
				d.setD_date(rs.getDate("d_date"));
			}
			// �̰� ���� �޾����� ��ȸ�� �ǰ��� ��������� ���̾ ��ü.
			
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
				request.setAttribute("r", "���� ����!");
			} else {
				request.setAttribute("r", "���� ����!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB ���� ����!");
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
			// ������ ���ϸ� �翬�� null,
			// ������ ���ϸ��� �����ϰ� ?�� �־��ָ�..
			int no = Integer.parseInt(mr.getParameter("no"));
			System.out.println(no);

			
			
				pstmt.setString(1, title);
				pstmt.setString(2, story);
				pstmt.setString(3, img);
				pstmt.setInt(4, no);

				if (pstmt.executeUpdate() == 1) {
					request.setAttribute("r", "�����Ϸ�~");
					if (pstmt.executeUpdate() == 1) {
						request.setAttribute("r", "�����Ϸ�~");
						pstmt.close();
						sql ="select*from Diary where d_no="+no;
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();
						if (rs.next()) {
						request.setAttribute("d_no", rs.getString("d_no"));
						}
				} else {
					request.setAttribute("r", "���� ���Ф̤�");
				}
			}
		 }catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB����");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void paging(int page, HttpServletRequest request) {
		request.setAttribute("curPageNo", page);

		// ��ü ������ �� ���
		int cnt = 10; // ���������� ������ ����
		int total = diarys.size(); // �� ������ ����

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
