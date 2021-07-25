package com.oz.main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


// DB ���� �۾��� �� �� �Ź� �����ڵ带 �� ���� �۾� �ؿ�

// AOP
public class DBManager {
	
	
public static Connection connect() throws NamingException, SQLException {
		
		// context.xml
		Context ctx = new InitialContext();
		
		// Connection �뿩��
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/ljh");
		return ds.getConnection();
	}
	
	// ������Ʈ -> �ڵ� -> ���� -> ���� ����
	
	
	
	

	
	// DB �۾��ÿ� ��·�� ���� �ؾߵ�
	/*
	  public static Connection connect() throws SQLException { String url =
	  "jdbc:oracle:thin:@localhost:1521:xe";
	  
	  return DriverManager.getConnection(url, "sj", "sj"); }
	 */
	
	// ������ ������ �ѹ��� �ݱ�
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
