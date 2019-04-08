package com.intimetec.restaurant.service.impl;

import java.util.ArrayList;

import com.intimetec.restaurant.constants.Constants;
import com.intimetec.restaurant.entity.MenuItem;
import com.intimetec.restaurant.persistent.MenuItemPersistent;
import com.intimetec.restaurant.persistent.impl.MenuItemPersistentImpl;
import com.intimetec.restaurant.service.MenuItemService;
import com.intimetec.restaurant.util.RestaurantUtil;

public class MenuItemServiceImpl implements MenuItemService {

	public ArrayList<MenuItem> getMenuItemList() {
		MenuItemPersistent menuItemPersistent = MenuItemPersistentImpl.getMenuItemPersistent();

		ArrayList<MenuItem> menuItemlist = null;

		menuItemlist = menuItemPersistent.getMenuItemList();

		if (menuItemlist != null) {
			for (MenuItem menuItem : menuItemlist) {
				menuItem.setItemName(RestaurantUtil.capitalizeFirstLetter(menuItem.getItemName()));
			}
			return menuItemlist;
		} else {
			return null;
		}
	}

	public String addMenuItem(MenuItem menuItem) {
		MenuItemPersistent menuItemPersistent = MenuItemPersistentImpl.getMenuItemPersistent();

		ArrayList<MenuItem> menuItemList = getMenuItemList();

		if (menuItemList != null) {
			if (!menuItemList.contains(menuItem)) {
				String result = menuItemPersistent.saveOrUpdateMenuItem(menuItem);
				return result;
			} else {
				return Constants.MENU_ITEM_ALREADY_PRESENT;
			}
		} else {
			return null;
		}
	}

	public String updateItem(MenuItem menuItem) {
		MenuItemPersistent menuItemPersistent = MenuItemPersistentImpl.getMenuItemPersistent();

		ArrayList<MenuItem> menuItemList = getMenuItemList();
		if (menuItemList != null) {
			int index = menuItemList.indexOf(menuItem);

			menuItem.setId(menuItemList.get(index).getId());

			String result = menuItemPersistent.saveOrUpdateMenuItem(menuItem);

			return result;
		} else {
			return null;
		}

	}

	public String deleteMenuItem(String[] listOfItemNameToBeDeleted) {
		ArrayList<MenuItem> listOfMenuItemToBeDeleted = prepareMenuItemList(listOfItemNameToBeDeleted);

		MenuItemPersistent menuItemPersistent = MenuItemPersistentImpl.getMenuItemPersistent();

		if (listOfMenuItemToBeDeleted != null) {
			String result = menuItemPersistent.deleteMenuItem(listOfMenuItemToBeDeleted);

			return result;
		} else {
			return null;
		}
	}

	private ArrayList<MenuItem> prepareMenuItemList(String[] listOfItemNameToBeDeleted) {
		ArrayList<MenuItem> menuItemList = getMenuItemList();

		ArrayList<MenuItem> listOfMenuItemToBeDeleted = new ArrayList<MenuItem>();

		if (menuItemList != null) {

			for (String itemName : listOfItemNameToBeDeleted) {
				MenuItem menuItem = new MenuItem();

				menuItem.setItemName(itemName);

				int index = menuItemList.indexOf(menuItem);

				listOfMenuItemToBeDeleted.add(menuItemList.get(index));

			}

			return listOfMenuItemToBeDeleted;

		} else {
			return null;
		}
	}

}
