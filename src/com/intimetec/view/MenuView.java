package com.intimetec.view;

import java.util.ArrayList;

import com.intimetec.entity.MenuItem;

public class MenuView {

	public void viewMenuList(ArrayList<MenuItem> menuList) {
		System.out.println("Sr no. \t ItemName\t\t price\tAvailability\n");
		for (MenuItem item : menuList) {
			System.out.print(menuList.indexOf(item));
			System.out.print("\t" + item.getItemName());
			for (int i = 15 + (item.getItemName().length()); i <= 38; i++) {
				System.out.print(" ");
			}
			System.out.print(item.getPrice());
			if (item.isAvailable()) {
				System.out.println("\t is available \n");
			} else {
				System.out.println("\tnot available \n");
			}
		}

	}

}
