package com.intimetec.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "RestaurantService")
public class RestaurantService {
	@Id
	@Type(type = "int")
	@Column(name = "serviceId")
	private int serviceId;

	@Type(type = "string")
	@Column(name = "serviceName")
	private String serviceName;

	@Type(type = "string")
	@Column(name = "serviceLink")
	private String serviceLink;

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceLink() {
		return serviceLink;
	}

	public void setServiceLink(String serviceLink) {
		this.serviceLink = serviceLink;
	}

}
