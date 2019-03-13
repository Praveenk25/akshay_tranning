package com.intimetec.entity;

import java.util.ArrayList;

public class OrderItem {
	private int orderNo;

	private String itemName;

	private float price;

	private int quantity;

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}

	public float getPrice() {
		return price;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		return itemName + ", price=" + price + ", quantity=" + quantity;
	}

}
