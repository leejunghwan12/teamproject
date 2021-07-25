package com.oz.main;

import java.sql.Date;

public class Info {
	
	private String j_name;
	private String j_id;
	private String j_pw;
	private String j_add;
	private String j_gender;
	private String j_phoneNum;
	private Date j_birth;

	public Info() {
		// TODO Auto-generated constructor stub
	}

	

	public Info(String j_name, String j_id, String j_pw, String j_add, String j_gender, String j_phoneNum,
			Date j_birth) {
		super();
		this.j_name = j_name;
		this.j_id = j_id;
		this.j_pw = j_pw;
		this.j_add = j_add;
		this.j_gender = j_gender;
		this.j_phoneNum = j_phoneNum;
		this.j_birth = j_birth;
	}



	public String getJ_name() {
		return j_name;
	}

	public void setJ_name(String j_name) {
		this.j_name = j_name;
	}

	public String getJ_id() {
		return j_id;
	}

	public void setJ_id(String j_id) {
		this.j_id = j_id;
	}

	public String getJ_pw() {
		return j_pw;
	}

	public void setJ_pw(String j_pw) {
		this.j_pw = j_pw;
	}

	public String getJ_add() {
		return j_add;
	}

	public void setJ_add(String j_add) {
		this.j_add = j_add;
	}


	public String getJ_gender() {
		return j_gender;
	}

	public void setJ_gender(String j_gender) {
		this.j_gender = j_gender;
	}

	public String getJ_phoneNum() {
		return j_phoneNum;
	}

	public void setJ_phoneNum(String j_phoneNum) {
		this.j_phoneNum = j_phoneNum;
	}

	public Date getJ_birth() {
		return j_birth;
	}

	public void setJ_birth(Date j_birth) {
		this.j_birth = j_birth;
	}

}