package com.intimetec.entity;

import java.sql.Date;
import java.sql.Time;

public class Order {
	private int orderNo;

	private String customerName;

	private String MobileNo;

	private Date date;

	private Time time;

	private boolean paymentStatus;

	private float totalAmount;

	public String getMobileNo() {
		return MobileNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
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
		return "orderNo=" + orderNo + ", customerName=" + customerName + ", MobileNo=" + MobileNo + ", " + date + ", "
				+ time;
	}

}
