package com.intimetec.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

import com.intimetec.exceptionOfRestaurentapp.InvalidDataException;

public class RestaurentApp {

	public static void main(String[] args) {

		String userOrder = null;
		String userOrderList[] = null;
		Scanner scan = new Scanner(System.in);

		HashSet<Menu> menuItem = new HashSet<Menu>();

		PrepareOrder prepareOrder = new PrepareOrder();
		Kitchen waiter = new Kitchen();

		menuItem.add(new Menu("Paneer butter Masala", true)); // creating item of menu
		menuItem.add(new Menu("Chana Masala", true));
		menuItem.add(new Menu("Sev tamater", true));
		menuItem.add(new Menu("Besan Gutta", true));
		menuItem.add(new Menu("Cauliflower (Gobi)", false));
		menuItem.add(new Menu("Malai Methi", true));
		menuItem.add(new Menu("Aloo Pyaj Paraatha", true));
		menuItem.add(new Menu("Gobi Paratha", false));
		menuItem.add(new Menu("Tandoor Roti", true));
		menuItem.add(new Menu("Tava Roti", true));

		// menuItem.add(new Menu("Chana Masala", false));

		ArrayList<Menu> menuList = new ArrayList<Menu>();
		menuList.addAll(menuItem);

		Collections.sort(menuList); // sorting the list in alphabetic order

		for (Menu item : menuList) { // print menu list on console
			System.out.print(menuList.indexOf(item) + "\t");
			System.out.println(item + "\n");
		}

		do {
			ArrayList<Menu> orderList = new ArrayList<Menu>();
			int flag = 1;

			System.out.println("\n Enter your order by serial no seperated by comma(,)"); // taking order in a string
			userOrder = scan.next();
			userOrderList = userOrder.split(",");

			try {

				for (int i = 0; i < userOrderList.length; i++) {
					if (userOrderList[i].length() == 1) { // check first input data is valid or not
						Menu m = menuList.get((int) userOrderList[i].charAt(0) - 48);
						if (m.available) { // checking availability
							orderList.add(m);
						} else {
							System.out.println(m.itemName + "\t is not available");
							flag = 0; // change the flag status
						}
					}

					else {
						throw new InvalidDataException();
					}
				}
			} catch (InvalidDataException e) {
				flag = 0;
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			if (flag != 0) // checking the flag status
			{
				System.out.println("your order is\t" + orderList); // print the order list
				prepareOrder.add(orderList); // sending the order list to prepare the order object and add into the
												// order queue
				waiter.notifyToChef();
			}
			orderList.clear(); // clearing the order list for next order

		} while (true);

	}

}
