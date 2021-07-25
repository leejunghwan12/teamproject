package com.oz.login;

import java.util.Date;

public class Account {

	private String id;
	private String pw;
	private String name;
	private String add;
	private String phonenum;
	private String gender;
	private Date birth;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String id, String pw, String name, String add, String phonenum, String gender, Date birth) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.add = add;
		this.phonenum = phonenum;
		this.gender = gender;
		this.birth = birth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
}
