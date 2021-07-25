package com.oz.gallery;

import java.util.Date;

public class Photo {
private int p_no;
private String p_title;
private String p_img;
private Date p_date;

public Photo() {
	// TODO Auto-generated constructor stub
}

public Photo(int p_no, String p_title, String p_img, Date p_date) {
	super();
	this.p_no = p_no;
	this.p_title = p_title;
	this.p_img = p_img;
	this.p_date = p_date;
}

public int getP_no() {
	return p_no;
}

public void setP_no(int p_no) {
	this.p_no = p_no;
}

public String getP_title() {
	return p_title;
}

public void setP_title(String p_title) {
	this.p_title = p_title;
}

public String getP_img() {
	return p_img;
}

public void setP_img(String p_img) {
	this.p_img = p_img;
}

public Date getP_date() {
	return p_date;
}

public void setP_date(Date p_date) {
	this.p_date = p_date;
}



}