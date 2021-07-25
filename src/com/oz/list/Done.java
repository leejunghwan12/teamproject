package com.oz.list;

public class Done {

	private int d_no;
	private String d_title;
	private int d_priority;
	private String d_names;
	
	public Done() {
		// TODO Auto-generated constructor stub

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

	public int getD_priority() {
		return d_priority;
	}

	public void setD_priority(int d_priority) {
		this.d_priority = d_priority;
	}

	public String getD_names() {
		return d_names;
	}

	public void setD_names(String d_names) {
		this.d_names = d_names;
	}

	public Done(int d_no, String d_title, int d_priority, String d_names) {
		super();
		this.d_no = d_no;
		this.d_title = d_title;
		this.d_priority = d_priority;
		this.d_names = d_names;
	}

	

}