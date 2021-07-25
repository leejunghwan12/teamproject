package com.oz.plan;

import java.sql.Date;

public class Event {

	private int e_no;
	private String e_name;
	private Date e_startDate;
	private Date e_endDate;

	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(int e_no, String e_name, Date e_startDate, Date e_endDate) {
		super();
		this.e_no = e_no;
		this.e_name = e_name;
		this.e_startDate = e_startDate;
		this.e_endDate = e_endDate;
	}

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public Date getE_startDate() {
		return e_startDate;
	}

	public void setE_startDate(Date e_startDate) {
		this.e_startDate = e_startDate;
	}

	public Date getE_endDate() {
		return e_endDate;
	}

	public void setE_endDate(Date e_endDate) {
		this.e_endDate = e_endDate;
	}
	
}
