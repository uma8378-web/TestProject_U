package com.javatpoint.beans;

public class BidderBean {
private int id;
private String name,email,postal;
private long mobile;

public BidderBean() {}

public BidderBean(int id, String name, String email, String postal, long mobile) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.postal = postal;
	this.mobile = mobile;
}
public BidderBean(String name, String email, String postal, long mobile) {
	super();
	this.name = name;
	this.email = email;
	this.postal = postal;
	this.mobile = mobile;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPostal() {
	return postal;
}
public void setPostal(String postal) {
	this.postal = postal;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}

}
