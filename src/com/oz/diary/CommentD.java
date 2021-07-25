package com.oz.diary;

import java.util.Date;

public class CommentD {

	private int c_no;
	private int c_board;
	private String c_id ; 
	private String c_text;
	private Date c_rdate;
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getC_board() {
		return c_board;
	}
	public void setC_board(int c_board) {
		this.c_board = c_board;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_text() {
		return c_text;
	}
	public void setC_text(String c_text) {
		this.c_text = c_text;
	}
	public Date getC_rdate() {
		return c_rdate;
	}
	public void setC_rdate(Date c_rdate) {
		this.c_rdate = c_rdate;
	}
	
	public CommentD(int c_no, int c_board, String c_id, String c_text, Date c_rdate) {
		super();
		this.c_no = c_no;
		this.c_board = c_board;
		this.c_id = c_id;
		this.c_text = c_text;
		this.c_rdate = c_rdate;
	}
	
	public CommentD() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	
}
