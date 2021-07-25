package com.oz.random;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oz.main.DBManager;

public class SensibilityDAO {

	
	
	
	public static void getSensibility(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		Random ran = new Random();
		int random = ran.nextInt(4)+1;
			
		
		
		try {
			
		
		
			con = DBManager.connect();
			
			String sql = "select * from travel_Sen where t_placeNo = ?";
			
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, random);
			
			
			rs = pstmt.executeQuery();
			
			Readtravel r = null;
			//rs.next 있으면 트루 없으면 false 
			if (rs.next()) {
				
				
			 r = new Readtravel();

			 r.setT_no(rs.getInt("t_no"));
			 r.setT_placeNo(rs.getInt("t_placeNo"));	
			 r.setT_title(rs.getString("t_title"));
			 r.setT_titleName(rs.getString("t_titleName"));
			 r.setT_address(rs.getString("t_address"));
			 r.setT_restaurant(rs.getString("t_restaurant"));
			 r.setT_restaurantName(rs.getString("t_restaurantName"));
			 r.setT_famous(rs.getString("t_famous"));
			 r.setT_famousName(rs.getString("t_famousName"));
			 
			}
			
			request.setAttribute("r", r);
			
		} catch (Exception e) {

		}finally {
			
			DBManager.close(con, pstmt, rs);
			
		}	
		
	}

	public static void upd(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();

			String sql = "insert into travel_Sen values(travel_Sen_seq.nextval,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);
			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 31457280, "utf-8",
					new DefaultFileRenamePolicy());

			
			int placeNo = Integer.parseInt(mr.getParameter("t_placeNo"));
			String title = mr.getFilesystemName("t_title");
			String titleName = mr.getParameter("t_titleName");
			String address = mr.getParameter("t_address");
			String restaurant = mr.getFilesystemName("t_restaurant");
			String restaurantName = mr.getParameter("t_restaurantName");
			String famous = mr.getFilesystemName("t_famous");
			String famousName = mr.getParameter("t_famousName");
			
			// 값을 잘 받고 나면 그걸 아래 물음표 채울때 쓰면 됨.
			pstmt.setInt(1, placeNo);
			pstmt.setString(2, title);
			pstmt.setString(3, titleName);
			pstmt.setString(4, address);
			pstmt.setString(5, restaurant);
			pstmt.setString(6, restaurantName);
			pstmt.setString(7, famous);
			pstmt.setString(8, famousName);
			

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
		
		
		
	}

	

