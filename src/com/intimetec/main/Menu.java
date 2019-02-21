package com.intimetec.main;

public class Menu implements Comparable<Menu> {
	String itemName;
	boolean available;

	public Menu(String itemname, boolean available) {
		super();
		this.itemName = itemname;
		this.available = available;
	}

	public String toString() {
		return itemName + " " + available;
	}

	public boolean equals(Object o) {
		Menu m = (Menu)o;
		return this.itemName.equalsIgnoreCase(m.itemName);
			
	}
	public int hashCode()
	{
		return ((int)this.itemName.charAt(2))+((int)this.itemName.charAt(0))*2 +(this.itemName.charAt(1)*3);
	}
	
	public int compareTo(Menu o) {
		if ((this.itemName).compareTo(o.itemName) > 0) {
			return 1;
		}
		else if ((this.itemName).compareTo(o.itemName) < 0)
			return -1;
		else
			return 0;
	}
}
