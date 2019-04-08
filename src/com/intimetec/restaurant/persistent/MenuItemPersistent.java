package com.intimetec.restaurant.persistent;

import java.util.ArrayList;

import com.intimetec.restaurant.entity.MenuItem;

public interface MenuItemPersistent {
	ArrayList<MenuItem> getMenuItemList();

	String saveOrUpdateMenuItem(MenuItem menuItem);

	String deleteMenuItem(ArrayList<MenuItem> listOfMenuItemToBeDeleted);

}
