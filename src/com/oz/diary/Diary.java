package com.oz.diary;

import java.util.Date;

public class Diary {
	
	private int d_no;
	private String d_title;
	private String d_story;
	private String d_img;
	private String d_writer;
	private Date d_date;

	public Diary() {
		// TODO Auto-generated constructor stub
	}

	public Diary(int d_no, String d_title, String d_story, String d_img, String d_writer, Date d_date) {
		super();
		this.d_no = d_no;
		this.d_title = d_title;
		this.d_story = d_story;
		this.d_img = d_img;
		this.d_writer = d_writer;
		this.d_date = d_date;
	}

	public int getD_no() {
		return d_no;
	}

	public void setD_no(int d_no) {
		this.d_no = d_no;
	}

	public String getD_title() {
		return d_title;
	}

	public void setD_title(String d_title) {
		this.d_title = d_title;
	}

	public String getD_story() {
		return d_story;
	}

	public void setD_story(String d_story) {
		this.d_story = d_story;
	}

	public String getD_img() {
		return d_img;
	}

	public void setD_img(String d_img) {
		this.d_img = d_img;
	}

	public String getD_writer() {
		return d_writer;
	}

	public void setD_writer(String d_writer) {
		this.d_writer = d_writer;
	}

	public Date getD_date() {
		return d_date;
	}

	public void setD_date(Date d_date) {
		this.d_date = d_date;
	}
	
	
	
}