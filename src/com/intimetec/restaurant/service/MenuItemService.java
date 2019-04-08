package com.intimetec.restaurant.service;

import java.util.ArrayList;

import com.intimetec.restaurant.entity.MenuItem;

public interface MenuItemService {
	ArrayList<MenuItem> getMenuItemList();

	String addMenuItem(MenuItem menuItem);

	public String updateItem(MenuItem menuItem);

	String deleteMenuItem(String[] listOfItemNameToBeDeleted);
}
