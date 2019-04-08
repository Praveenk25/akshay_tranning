package com.intimetec.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "UserServiceId")
public class UserServiceId {
	@Id
	@Type(type = "int")
	@Column(name = "serialNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serialNo;

	@Type(type = "int")
	@Column(name = "roleId")
	private int roleId;

	@Type(type = "int")
	@Column(name = "ServiceId")
	private int ServiceId;

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getServiceId() {
		return ServiceId;
	}

	public void setServiceId(int serviceId) {
		ServiceId = serviceId;
	}

}
