package com.javatpoint.beans;

public class ProductBean {
private String itemno,name;
private int quantity,price,soldout;
public ProductBean() {
	super();
	// TODO Auto-generated constructor stub
}
public ProductBean(String itemno, String name, int quantity, int price) {
	super();
	this.itemno = itemno;
	this.name = name;
	this.quantity = quantity;
	this.price= price;
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
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getSoldout() {
	return soldout;
}
public void setSoldout(int soldout) {
	this.soldout = soldout;
}

}
