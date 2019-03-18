package com.intimetec.main;

import java.util.Scanner;

import com.intimetec.constants.Constants;
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
			System.out.println(Constants.APPLICATION_FEATURES);
			
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
				scan.close();
				System.exit(0);
			default:
				System.out.println(Constants.WRONG_INPUT);
			}
		} while (true);

	}

}
