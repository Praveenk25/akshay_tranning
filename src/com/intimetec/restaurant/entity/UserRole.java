package com.intimetec.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "UserRole")
public class UserRole {
	@Id
	@Type(type = "int")
	@Column(name = "roleId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;

	@Type(type = "string")
	@Column(name = "roleName")
	private String roleName;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
