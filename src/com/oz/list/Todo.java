package com.oz.list;

public class Todo {

	private int t_no;
	private String t_title;
	private String t_priority;
	private String t_names;
	
	
	public Todo() {
		// TODO Auto-generated constructor stub
	}


	public int getT_no() {
		return t_no;
	}


	public void setT_no(int t_no) {
		this.t_no = t_no;
	}


	public String getT_title() {
		return t_title;
	}


	public void setT_title(String t_title) {
		this.t_title = t_title;
	}


	public String getT_priority() {
		return t_priority;
	}


	public void setT_priority(String t_priority) {
		this.t_priority = t_priority;
	}


	public String getT_names() {
		return t_names;
	}


	public void setT_names(String t_names) {
		this.t_names = t_names;
	}


	public Todo(int t_no, String t_title, String t_priority, String t_names) {
		super();
		this.t_no = t_no;
		this.t_title = t_title;
		this.t_priority = t_priority;
		this.t_names = t_names;
	}
	
	
	
}
