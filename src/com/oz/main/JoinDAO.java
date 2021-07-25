package com.oz.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oz.main.JoinDAO;

public class JoinDAO {

	ArrayList<Info> info = new ArrayList<Info>();

	private static final JoinDAO SDAO = new JoinDAO();

	private JoinDAO() {

	}

	public static JoinDAO getSdao() {
		return SDAO;
	}

	public void join(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();

			String sql = "insert into join values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			request.setCharacterEncoding("utf-8");

			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			String birth_y = request.getParameter("birth_y");
			String birth_m = request.getParameter("birth_m");
			String birth_d = request.getParameter("birth_d");
			String sBirth = birth_y + "-" + birth_m + "-" + birth_d;
			Date birth = Date.valueOf(sBirth);

			String gen = request.getParameter("gen");

			String phoneNum_f = request.getParameter("phoneNum_f");
			String phoneNum_s = request.getParameter("phoneNum_s");
			String phoneNum_t = request.getParameter("phoneNum_t");
			String phoneNum = phoneNum_f + "-" + phoneNum_s + "-" + phoneNum_t;
			System.out.println(phoneNum);
			String[] test = phoneNum.split("-");
			for (String s : test) {
				System.out.println(s);
			}

			String add = request.getParameter("add");

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, add);
			pstmt.setString(5, phoneNum);
			pstmt.setString(6, gen);
			pstmt.setDate(7, birth);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "환영합니다~:)");
			} else {
				request.setAttribute("r", "잘못입력하셨습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB error");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void redub(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();

			String sql = "select * from join where j_id = ?";
			pstmt = con.prepareStatement(sql);

			String id = request.getParameter("id");

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			int ok = 0;
			if (rs.next()) {
				request.setAttribute("r", "사용할 수 없는 ID입니다.");
			} else {
				request.setAttribute("r", "사용할 수 있는 ID입니다.");
				ok = 1;
				request.setAttribute("okok", ok);
				request.setAttribute("iid", id);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void getInfo(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();

			String sql = "select * from join where j_id = ? ";
			pstmt = con.prepareStatement(sql);
			String id = request.getParameter("id");
			// String pw = request.getParameter("pw");

			String birth_y = request.getParameter("birth_y");
			String birth_m = request.getParameter("birth_m");
			String birth_d = request.getParameter("birth_d");
			request.setAttribute("birth_y", birth_y);

			String phoneNum_f = request.getParameter("phoneNum_f");
			String phoneNum_s = request.getParameter("phoneNum_s");
			String phoneNum_t = request.getParameter("phoneNum_t");

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			Info i = null;

			if (rs.next()) {
				i = new Info();
				i.setJ_id(rs.getString("j_id"));
				i.setJ_name(rs.getString("j_name"));
				i.setJ_pw(rs.getString("j_pw"));
				i.setJ_birth(rs.getDate("j_birth"));
				i.setJ_gender(rs.getString("j_gender"));
				i.setJ_phoneNum(rs.getString("j_phoneNum"));
				i.setJ_add(rs.getString("j_add"));

				String db_pw = rs.getString("j_pw");
				request.setAttribute("db_pw", db_pw);
			}
			request.setAttribute("info", i);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}


	
	
	public void change(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();

			String sql = "update join " + "set j_name=?, j_add=?, j_gender=?, j_phoneNum=?, j_birth=?" + "where j_id=?";
			pstmt = con.prepareStatement(sql);

			request.setCharacterEncoding("utf-8");

			String name = request.getParameter("name");
			String id = request.getParameter("id");

			String birth_y = request.getParameter("birth_y");
			String birth_m = request.getParameter("birth_m");
			String birth_d = request.getParameter("birth_d");
			String sBirth = birth_y + "-" + birth_m + "-" + birth_d;
			Date birth = Date.valueOf(sBirth);

			String gen = request.getParameter("gen");

			String phoneNum_f = request.getParameter("phoneNum_f");
			String phoneNum_s = request.getParameter("phoneNum_s");
			String phoneNum_t = request.getParameter("phoneNum_t");
			String phoneNum = phoneNum_f + "-" + phoneNum_s + "-" + phoneNum_t;
			System.out.println(phoneNum);

			String add = request.getParameter("add");

			pstmt.setString(1, name);
			pstmt.setString(2, add);
			pstmt.setString(3, phoneNum);
			pstmt.setString(4, gen);
			pstmt.setDate(5, birth);
			pstmt.setString(6, id);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "회원 정보가 수정되었습니다");
			} else {
				request.setAttribute("r", "다시 시도해보세요");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void delete(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();

			String sql = "delete join where j_id=?";
			pstmt = con.prepareStatement(sql);

			request.setCharacterEncoding("utf-8");

			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			pstmt.setString(1, id);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제되었습니다.");
			}
			request.setAttribute("r", "다시 시도해주세요.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void dividePN(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();

			String sql = "SELECT j_phoneNum frOM join where j_id = ?";
			pstmt = con.prepareStatement(sql);
			String id = request.getParameter("id");

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getString("j_phoneNum"));
			String temp = rs.getString("j_phoneNum");
			String temp2[] = temp.split("-");
			System.out.println(temp2[0]);
			System.out.println(temp2[1]);
			System.out.println(temp2[2]);

			request.setAttribute("phoneNum_f", temp2[0]);
			request.setAttribute("phoneNum_s", temp2[1]);
			request.setAttribute("phoneNum_t", temp2[0]);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void divideBD(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();

			String sql = "SELECT j_birth, SUBSTR(j_birth, 1, 2) , SUBSTR(j_birth, 4, 2), SUBSTR(j_birth, 7, 2) "
					+ "FROM join";
			pstmt = con.prepareStatement(sql);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

}