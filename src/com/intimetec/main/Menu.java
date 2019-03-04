package com.intimetec.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

public class Menu implements Comparable<Menu> {
	String itemName;
	boolean available;

	public Menu(String itemname, boolean available) {
		super();
		this.itemName = itemname;
		this.available = available;
	}

	public String toString() {
		return itemName + " ";
	}

	public boolean equals(Object o) {
		Menu m = (Menu) o;
		return this.itemName.equalsIgnoreCase(m.itemName);

	}

	public int hashCode() {

		return ((int) this.itemName.charAt(0)) + ((int) this.itemName.charAt(1)) * 2 + (this.itemName.charAt(2) * 3);
	}

	public int compareTo(Menu o) {
		if ((this.itemName).compareTo(o.itemName) > 0) {
			return 1;
		} else if ((this.itemName).compareTo(o.itemName) < 0)
			return -1;
		else
			return 0;
	}

	public static ArrayList<Menu> getMenuList() {
		String selectQuery = "SELECT itemName,availability FROM Menu";
		HashSet<Menu> menuItem = new HashSet<Menu>();
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		Connection connection = DatabaseConnection.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;

		if (connection != null) {
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(selectQuery);
				while (resultSet.next()) {
					menuItem.add(new Menu(resultSet.getString(1), resultSet.getBoolean(2)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("connectivity issue");
		}
		menuList.addAll(menuItem);
		return menuList;
	}

}
