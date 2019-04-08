package com.intimetec.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "User")
public class User {
	@Id
	@Type(type = "string")
	@Column(name = "username")
	private String username;

	@Type(type = "string")
	@Column(name = "fullName")
	private String fullName;

	@Type(type = "string")
	@Column(name = "mobileNumber")
	private String mobileNumber;

	@Type(type = "string")
	@Column(name = "password")
	private String password;

	@Type(type = "int")
	@Column(name = "roleId")
	private int roleId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object obj) {
		User a = (User) obj;
		return this.username.equalsIgnoreCase(a.username);
	}

}
