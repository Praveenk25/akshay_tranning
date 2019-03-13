package com.intimetec.main;

import java.util.Scanner;

import com.intimetec.controller.MenuController;
import com.intimetec.controller.MenuControllerImpl;
import com.intimetec.controller.OrderController;
import com.intimetec.controller.OrderControllerImpl;
import com.intimetec.model.DatabaseConnection;

public class RestaurentApp {

	public static void main(String[] args) {
		char choice;

		Scanner scan = new Scanner(System.in);

		MenuController menuController = new MenuControllerImpl();
		OrderController orderController = new OrderControllerImpl();
		do {
			System.out.println("1.View Menu List");
			System.out.println("2.Add Menu Item");
			System.out.println("3.Delete Menu Item");
			System.out.println("4.Update Menu Item");
			System.out.println("5.Create Order");
			System.out.println("6.View Order");
			System.out.println("7.Exit");

			choice = scan.next().charAt(0);

			switch (choice) {
			case '1':
				menuController.viewMenuList();
				break;
			case '2':
				menuController.addMenuItem();
				break;
			case '3':
				menuController.deleteMenuItem();
				break;
			case '4':
				menuController.updateItem();
				break;
			case '5':
				orderController.newOrder();
				break;
			case '6':
				orderController.viewOrder();
				break;
			case '7':
				DatabaseConnection.closeConnection();
				System.exit(0);
			default:
				System.out.println("you give wrong input");
			}
		} while (true);

	}

}
