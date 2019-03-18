package com.intimetec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "orderItems")
public class OrderItem {

	@Id
	@Type(type = "int")
	@Column(name = "serialNo")
	@GeneratedValue
	private int serialNo;

	@ManyToOne
	private Order order;

	@Type(type = "string")
	@Column(name = "orderItem")
	private String itemName;

	@Type(type = "float")
	@Column(name = "price")
	private float price;

	@Type(type = "int")
	@Column(name = "quantity")
	private int quantity;

	public int getSerialNo() {
		return serialNo;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		return itemName + ", price=" + price + ", quantity=" + quantity;
	}

}
