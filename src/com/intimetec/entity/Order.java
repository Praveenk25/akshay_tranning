package com.intimetec.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@Type(type = "int")
	@Column(name = "orderNo")
	@GeneratedValue
	private int orderNo;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<>(); 
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Type(type = "string")
	@Column(name = "CustomerName")
	private String customerName;

	@Type(type = "string")
	@Column(name = "mobileNo")
	private String mobileNo;

	@Type(type = "date")
	@Column(name = "OrderDate")
	private Date date;

	@Type(type = "time")
	@Column(name = "time")
	private Time time;

	@Type(type = "boolean")
	@Column(name = "paymentStatus")
	private boolean paymentStatus;

	@Type(type = "float")
	@Column(name = "totalAmount")
	private float totalAmount;

	public String getMobileNo() {
		return mobileNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Time getTime() {
		return time;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Date getDate() {
		return date;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String toString() {
		return "orderNo=" + orderNo + ", customerName=" + customerName + ", mobileNo=" + mobileNo + ", " + date + ", "
				+ time;
	}

}
