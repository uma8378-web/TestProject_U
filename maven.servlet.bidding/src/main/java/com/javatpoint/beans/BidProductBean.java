package com.javatpoint.beans;

import java.sql.Date;

public class BidProductBean {
private String itemno,name;
private int bidprice,bidderid;
private Date biddate;
private String biddingstatus;

public BidProductBean() {}
public BidProductBean(String itemno, String name, int bidprice) {
	super();
	this.itemno = itemno;
	this.name = name;
	this.bidprice = bidprice;
	this.bidderid = bidderid;
}

public String getBiddingstatus() {
	return biddingstatus;
}
public void setBiddingstatus(String biddingstatus) {
	this.biddingstatus = biddingstatus;
}
public Date getBiddate() {
	return biddate;
}
public void setBiddate(Date biddate) {
	this.biddate = biddate;
}
public String getItemno() {
	return itemno;
}
public void setItemno(String itemno) {
	this.itemno = itemno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getBidprice() {
	return bidprice;
}
public void setBidprice(int bidprice) {
	this.bidprice = bidprice;
}
public int getBidderid() {
	return bidderid;
}
public void setBidderid(int bidderid) {
	this.bidderid = bidderid;
}
}
