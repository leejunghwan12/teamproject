package com.oz.plan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.oz.list.Todo;
import com.oz.list.TodoDAO;
import com.oz.main.DBManager;

public class PlanDAO {

	private ArrayList<Event> events;
	private static final PlanDAO PDAO = new PlanDAO();

	public PlanDAO() {
	}

	public static PlanDAO getPdao() {
		return PDAO;
	}

	public static void cal(HttpServletRequest request) {

		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
				
		int nowYear = cal.get(Calendar.YEAR);
		int nowMonth = cal.get(Calendar.MONTH) + 1;
		
		String fYear = request.getParameter("year");
		String fMonth = request.getParameter("month");
		
		int year = nowYear;
		int month = nowMonth;

		if (fYear != null) {
			year = Integer.parseInt(fYear);
		}

		if (fMonth != null) {
			month = Integer.parseInt(fMonth);
		}

		cal.set(year, month - 1, 1);

		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;

		int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);

		request.setAttribute("endDay", endDay);
		request.setAttribute("week", week);
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		

	}

	public void regPlan(HttpServletRequest request, HttpServletResponse Response) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();

			String sql = "insert into event values (event_seq.nextval,?,?,?)";
			pstmt = con.prepareStatement(sql);

			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("name");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			
			java.sql.Date startdate = java.sql.Date.valueOf(startDate);
			java.sql.Date enddate = java.sql.Date.valueOf(endDate);


			pstmt.setString(1, name);
			pstmt.setDate(2, startdate);
			pstmt.setDate(3, enddate);
	
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "등록성공!");
				request.setAttribute("startdate", startdate);
				request.setAttribute("enddate", enddate);
			} else {
				PrintWriter out = Response.getWriter();

				out.println("<script>alert('다시 시도하세요.'); onclick='window.close()';</script>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void showAllPlan(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();

			String sql = "select * from event";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			events = new ArrayList<Event>();


			Event e = null;
			while (rs.next()) {
				e = new Event();
				e.setE_no(rs.getInt("e_no"));
				e.setE_name(rs.getString("e_name"));
				e.setE_startDate(rs.getDate("e_startDate"));
				e.setE_endDate(rs.getDate("e_endDate"));
				events.add(e);

			}
			request.setAttribute("events", events);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void divideDate(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();

			String sql = "SELECT * from event";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			
			Calender c = null;
			ArrayList<Calender> calenderlist = new  ArrayList<Calender>();
			
			while (rs.next()) {
				java.util.Date dd = rs.getDate("e_startDate");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
				String myDate = sdf.format(dd);
				String temp2[] = myDate.split("-");

				request.setAttribute("startDate_y", temp2[0]);
				request.setAttribute("startDate_m", temp2[1]);
				request.setAttribute("startDate_d", temp2[2]);
				
				String s_year = temp2[0];
				String s_month = temp2[1];
				String s_day = temp2[2];
				
				java.util.Date end = rs.getDate("e_endDate");
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-M-d");
				String endDate = sdf2.format(end);
				

				String temp[] = endDate.split("-");
				request.setAttribute("endDate_y", temp[0]);
				request.setAttribute("endDate_m", temp[1]);
				request.setAttribute("endDate_d", temp[2]);
				
				String e_year = temp[0];
				String e_month = temp[1];
				String e_day = temp[2];
				
				c = new Calender();
				c.setC_no(1);		
				c.setS_day(s_day);
				c.setS_month(s_month);
				c.setS_year(s_year);
				c.setE_day(e_day);
				c.setE_month(e_month);
				c.setE_year(e_year);
				c.setE_name(rs.getString("e_name"));	
				
				calenderlist.add(c);
				
			}
			
				request.setAttribute("calenderlist", calenderlist);
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	
	
		
	
}
