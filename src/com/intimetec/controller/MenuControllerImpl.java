package com.intimetec.controller;

import java.util.ArrayList;
import java.util.Scanner;

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

		System.out.print("Item name : ");
		menuItem.setItemName(scan.nextLine());

		System.out.print("\nPrice : ");
		menuItem.setPrice(scan.nextInt());

		System.out.print("\nPress Y for available  &  N for not available: ");
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

		System.out.print("enter item name you want to delete : ");
		menuService.deleteMenuItem(scan.nextLine());

	}

	public void updateItem() {
		MenuItem menuItem = new MenuItem();

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter Item name you want to update : ");
		menuItem.setItemName(scan.nextLine());

		System.out.print("\n new Price : ");
		menuItem.setPrice(scan.nextInt());

		System.out.print("\nPress Y for available  &  N for not available: ");
		char available = scan.next().charAt(0);
		if (available == 'y' || available == 'Y') {
			menuItem.setAvailable(true);
		} else {
			menuItem.setAvailable(false);
		}
		menuService.updateItem(menuItem);
	}

}
