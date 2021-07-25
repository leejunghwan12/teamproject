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
			request.setAttribute("loginPage", "login/prelogin.jsp"); //�α��� ����
			request.setAttribute("l","no" );
		
		}else {
			request.setAttribute("loginPage", "login/loginOk.jsp"); //�α��� ����
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
					hs.setAttribute("accountInfo", a); //���� �Ҳ���
					hs.setMaxInactiveInterval(60*30);
			
					request.setAttribute("r", "�α��� ����");
					request.setAttribute("contentPage", "home.jsp");

				}else {
					request.setAttribute("r", "��й�ȣ�� Ȯ�����ּ���.");
					request.setAttribute("contentPage", "login/login.jsp");
				}
			
			}else {
				request.setAttribute("r", "������ Ȯ�����ּ���.");
				request.setAttribute("contentPage", "login/login.jsp");
			}
			
			
		} catch (Exception e) {
			request.setAttribute("r", "DB ��������");
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
