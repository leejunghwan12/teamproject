package com.oz.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oz.main.DBManager;

public class AccountDao {

	
	public static void loginCheck(HttpServletRequest request) {

		
		HttpSession hs = request.getSession();
		Account	a =	(Account) hs.getAttribute("accountInfo");
//		Account	a = (Account)request.getAttribute("a");
					
		
		if (a == null) {
			request.setAttribute("loginPage", "login/prelogin.jsp"); //로그인 실패
			request.setAttribute("l","no" );
		
		}else {
			request.setAttribute("loginPage", "login/loginOk.jsp"); //로그인 성공
			request.setAttribute("l","ok" );
			if (a.getId().equals("pred")) {
				request.setAttribute("pred", "pred");
			}
			

		
		}
		
		
		
		
	}
	
	
	public static void login(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		try {
			con = DBManager.connect();
			String id = request.getParameter("id"); 
			String pw = request.getParameter("pw");
			
			String sql = "select * from join where j_id= ? ";

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
			String db_pw = rs.getString("j_pw"); 

				if (pw.equals(db_pw)) {
					
					Account a = new Account();
					a.setId(rs.getString("j_id"));
					a.setPw(rs.getString("j_pw"));
					a.setName(rs.getString("j_name"));
					a.setAdd(rs.getString("j_add"));
					a.setGender(rs.getString("j_gender"));
					a.setBirth(rs.getDate("j_birth"));
					a.setPhonenum(rs.getString("j_phoneNUm"));
					
					HttpSession hs = request.getSession();
					hs.setAttribute("accountInfo", a); //뭐로 할꺼냐
					hs.setMaxInactiveInterval(60*30);
			
					request.setAttribute("r", "로그인 성공");
					request.setAttribute("contentPage", "home.jsp");

				}else {
					request.setAttribute("r", "비밀번호를 확인해주세요.");
					request.setAttribute("contentPage", "login/login.jsp");
				}
			
			}else {
				request.setAttribute("r", "계정을 확인해주세요.");
				request.setAttribute("contentPage", "login/login.jsp");
			}
			
			
		} catch (Exception e) {
			request.setAttribute("r", "DB 서버문제");
			request.setAttribute("contentPage", "login/login.jsp");

			e.printStackTrace();
			
		}finally {
			DBManager.close(con, pstmt, rs);
			
		}
		
		
	}


	public static void logOut(HttpServletRequest request) {

		HttpSession hs = request.getSession();
		hs.invalidate();
		
	}

}
