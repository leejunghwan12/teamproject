package com.oz.main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


// DB 관련 작업을 할 때 매번 연결코드를 쓴 이후 작업 해옴

// AOP
public class DBManager {
	
	
public static Connection connect() throws NamingException, SQLException {
		
		// context.xml
		Context ctx = new InitialContext();
		
		// Connection 대여소
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/ljh");
		return ds.getConnection();
	}
	
	// 프로젝트 -> 코드 -> 배포 -> 서비스 시작
	
	
	
	

	
	// DB 작업시엔 어쨌든 연결 해야됨
	/*
	  public static Connection connect() throws SQLException { String url =
	  "jdbc:oracle:thin:@localhost:1521:xe";
	  
	  return DriverManager.getConnection(url, "sj", "sj"); }
	 */
	
	// 닫을게 많은데 한번에 닫기
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
	
		 try {
			 if (rs!=null) {
				 rs.close();
			}
	      } catch (SQLException e) {
	      }

	      try {
	    	  if (pstmt!=null) {
	    		  pstmt.close();
	    	}
	      }catch (SQLException e) {
	      }

	      try {
	    	  if (con!=null) {
	    		  con.close();
			}
	      } catch (SQLException e) {
	      }

	
	
	}
		
	

}
