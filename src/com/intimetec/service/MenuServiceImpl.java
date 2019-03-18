package com.intimetec.service;

import java.util.ArrayList;
import java.util.Collections;

import com.intimetec.constants.Constants;
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

		}
		callFlag = false;
		return menuList;
	}

	public void addMenuItem(MenuItem menuItem) {
		ArrayList<MenuItem> menuList = getMenuList();

		if (!menuList.contains(menuItem)) {
			menuPersistent.addMenuItem(menuItem);

			callFlag = true;
		} else {
			System.out.println(Constants.ITEM_ALREADY_PRESENT);
		}
	}

	public void deleteMenuItem(MenuItem menuItem) {
		ArrayList<MenuItem> menuList = getMenuList();

		if (menuList.contains(menuItem)) {
			int index = menuList.indexOf(menuItem);

			menuPersistent.deleteMenuItem(menuList.get(index));

			callFlag = true;
		} else {
			System.out.println(Constants.ITEM_NOT_EXIST);
		}

	}

	public void updateItem(MenuItem menuItem) {
		ArrayList<MenuItem> menuList = getMenuList();

		if (menuList.contains(menuItem)) {
			int index = menuList.indexOf(menuItem);

			menuPersistent.updateItem(menuList.get(index));

			callFlag = true;
		} else {
			System.out.println(Constants.ITEM_NOT_EXIST);
		}

	}

}
