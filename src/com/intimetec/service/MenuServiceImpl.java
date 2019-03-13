package com.intimetec.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.intimetec.entity.MenuItem;
import com.intimetec.model.MenuPersistent;
import com.intimetec.model.MenuPersistentImpl;

public class MenuServiceImpl implements MenuService {
	MenuPersistent menuPersistent = new MenuPersistentImpl();

	ArrayList<MenuItem> menuList;

	boolean callFlag = true;

	public ArrayList<MenuItem> getMenuList() {

		if (callFlag) {
			menuList = menuPersistent.getMenuList();

			Collections.sort(menuList);
		}
		callFlag = false;
		return menuList;
	}

	public void addMenuItem(MenuItem menuItem) {
		callFlag = true;

		menuPersistent.addMenuItem(menuItem);
	}

	public void deleteMenuItem(String itemName) {
		callFlag = true;

		menuPersistent.deleteMenuItem(itemName);

	}

	public void updateItem(MenuItem menuItem) {
		callFlag = true;

		menuPersistent.updateItem(menuItem);
	}

}
