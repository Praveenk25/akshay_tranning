package com.intimetec.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.intimetec.customException.InvalidOrderNo;
import com.intimetec.entity.MenuItem;
import com.intimetec.entity.Order;
import com.intimetec.entity.OrderItem;
import com.intimetec.service.MenuService;
import com.intimetec.service.MenuServiceImpl;
import com.intimetec.service.OrderService;
import com.intimetec.service.OrderServiceImpl;
import com.intimetec.view.OrderViewImpl;

public class OrderControllerImpl implements OrderController {
	OrderViewImpl orderView = new OrderViewImpl();

	OrderService orderService = new OrderServiceImpl();

	public void newOrder() {
		MenuService menuService = new MenuServiceImpl();

		Order order = new Order();

		ArrayList<OrderItem> orderList = new ArrayList<OrderItem>();

		Scanner scan = new Scanner(System.in);

		System.out.println("Customer Name : ");
		order.setCustomerName(scan.nextLine());

		System.out.println("customer mobile no : ");
		order.setMobileNo(scan.next());

		ArrayList<MenuItem> menuList;

		menuList = menuService.getMenuList();

		{
			char choice;

			do {
				System.out.println("\n Enter your order by serial no");

				int serialNo = scan.nextInt();

				try {
					if (serialNo < menuList.size()) {

						if (menuList.get(serialNo).isAvailable()) {
							OrderItem orderItem = new OrderItem();

							orderItem.setItemName(menuList.get(serialNo).getItemName());
							orderItem.setPrice(menuList.get(serialNo).getPrice());

							System.out.println("please enter the quantity");
							orderItem.setQuantity(scan.nextInt());

							orderList.add(orderItem);
						} else {
							System.out.println(menuList.get(serialNo).getItemName() + " is not available");
						}
					} else {
						throw new InvalidOrderNo();
					}
				} catch (InvalidOrderNo e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("please enter valid input");
					System.out.println(e.getMessage());
				}

				System.out.println("For add more press Y  &  to Submit order press any key ");
				choice = scan.next().charAt(0);
			} while (choice == 'y' || choice == 'Y');
		}
		order = orderService.submitOrder(order, orderList);

		orderView.viewOrder(order, orderList);
	}

	public void viewOrder() {
		Order order;

		ArrayList<OrderItem> orderList;

		Scanner scan = new Scanner(System.in);

		System.out.println("give the Order no");

		int orderNo = scan.nextInt();

		order = orderService.getOrder(orderNo);

		if (order != null) {
			orderList = orderService.getOrderList(orderNo);

			orderView.viewOrder(order, orderList);
		}
	}

}
