package com.intimetec.service;

import java.util.ArrayList;

import com.intimetec.entity.MenuItem;

public interface MenuService {

	ArrayList<MenuItem> getMenuList();

	void addMenuItem(MenuItem menuItem);

	void deleteMenuItem(MenuItem menuItem);

	public void updateItem(MenuItem menuItem);

}
