package com.intimetec.restaurant.entity;

public class MenuItem {
	private int Id;

	private String itemName;

	private float price;

	private boolean available;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean equals(Object obj) {
		MenuItem m = (MenuItem) obj;
		return this.itemName.equalsIgnoreCase(m.itemName);
	}

}
