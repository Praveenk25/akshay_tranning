package com.intimetec.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.intimetec.constants.Constants;
import com.intimetec.entity.MenuItem;
import com.intimetec.service.MenuService;
import com.intimetec.service.MenuServiceImpl;
import com.intimetec.view.MenuView;

public class MenuControllerImpl implements MenuController {
	MenuService menuService = new MenuServiceImpl();

	public void viewMenuList() {
		ArrayList<MenuItem> menuList;

		menuList = menuService.getMenuList();

		if (!menuList.isEmpty()) {
			MenuView menuView = new MenuView();
			menuView.viewMenuList(menuList);
		}
	}

	public void addMenuItem() {
		MenuItem menuItem = new MenuItem();

		Scanner scan = new Scanner(System.in);

		System.out.print(Constants.ITEM_NAME);
		menuItem.setItemName(scan.nextLine());

		System.out.print(Constants.ITEM_PRICE);
		menuItem.setPrice(scan.nextInt());

		System.out.print(Constants.ITEM_AVAILABILITY);
		char available = scan.next().charAt(0);
		if (available == 'y' || available == 'Y') {
			menuItem.setAvailable(true);
		} else {
			menuItem.setAvailable(false);
		}

		menuService.addMenuItem(menuItem);
	}

	public void deleteMenuItem() {
		Scanner scan = new Scanner(System.in);
		
		MenuItem menuItem = new MenuItem();
		System.out.print(Constants.DELETE_ITEM);
		menuItem.setItemName(scan.nextLine());
		
		menuService.deleteMenuItem(menuItem);

	}

	public void updateItem() {
		MenuItem menuItem = new MenuItem();

		Scanner scan = new Scanner(System.in);

		System.out.print(Constants.UPDATE_ITEM_NAME);
		menuItem.setItemName(scan.nextLine());

		System.out.print(Constants.ITEM_PRICE);
		menuItem.setPrice(scan.nextInt());

		System.out.print(Constants.ITEM_AVAILABILITY);
		char available = scan.next().charAt(0);
		if (available == 'y' || available == 'Y') {
			menuItem.setAvailable(true);
		} else {
			menuItem.setAvailable(false);
		}
		menuService.updateItem(menuItem);
	}

}
