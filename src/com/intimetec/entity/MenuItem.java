package com.intimetec.entity;

public class MenuItem implements Comparable<MenuItem> {
	private String itemName;

	private float price;

	private boolean available;

	public MenuItem() {

	}

	public String getItemName() {
		return itemName;
	}

	public float getPrice() {
		return price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String toString() {
		return itemName + " ";
	}

	public boolean equals(Object obj) {
		MenuItem m = (MenuItem) obj;
		return this.itemName.equalsIgnoreCase(m.itemName);
	}

	public int hashCode() {
		return itemName.hashCode();
	}

	public int compareTo(MenuItem o) {
		if ((this.itemName).compareTo(o.itemName) > 0) {
			return 1;
		} else if ((this.itemName).compareTo(o.itemName) < 0)
			return -1;
		else
			return 0;
	}
}
