package com.oz.list;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oz.main.DBManager;

public class ListDAO {
	
	private ArrayList<Name> namelist;

	private static final ListDAO SDAO = new ListDAO();

	public ListDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static ListDAO getSdao() {
		return SDAO;
	}


	public void getNameList(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();

			String sql = "select j_name from join";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
		   namelist = new ArrayList<Name>();
			   

			Name n = null;
			while (rs.next()) {
				n = new Name();
				System.out.println(rs.getString("j_name"));
				n.setName(rs.getString("j_name"));
				namelist.add(n);
			}
			request.setAttribute("namelist", namelist);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}
	
	
	
	

}
