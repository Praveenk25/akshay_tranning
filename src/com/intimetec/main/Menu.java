package com.intimetec.main;

public class Menu implements Comparable<Menu> {
	String itemname;
	boolean available;

	public Menu(String itemname, boolean available) {
		super();
		this.itemname = itemname;
		this.available = available;
	}

	public String toString() {
		return itemname + "\t\t" + available;
	}

	@Override
	public int compareTo(Menu o) {
		if ((this.itemname).compareTo(o.itemname) >= 0) {
			return 1;
		}
		return -1;
	}
}
