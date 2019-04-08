package com.intimetec.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "OrderItem")
public class OrderItem {
	@Id
	@Type(type = "int")
	@Column(name = "serialNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serialNo;

	@ManyToOne
	private Order order;

	@Type(type = "string")
	@Column(name = "orderItem")
	private String itemName;

	@Type(type = "int")
	@Column(name = "quantity")
	private int quantity;

	@Type(type = "float")
	@Column(name = "price")
	private float price;

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
