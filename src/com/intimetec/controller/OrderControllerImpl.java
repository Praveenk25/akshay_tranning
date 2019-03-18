package com.intimetec.controller;

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;

import com.intimetec.constants.Constants;
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

		char choice;

		int count = 0;
		do {
			System.out.println(Constants.ASKING_ORDER);

			int serialNo = scan.nextInt();

			if (serialNo < menuList.size()) {

				if (menuList.get(serialNo).isAvailable()) {
					OrderItem orderItem = new OrderItem();

					orderItem.setItemName(menuList.get(serialNo).getItemName());
					orderItem.setPrice(menuList.get(serialNo).getPrice());

					System.out.println("please enter the quantity");
					orderItem.setQuantity(scan.nextInt());

					orderList.add(orderItem);
					count++;
				} else {
					System.out.println(menuList.get(serialNo).getItemName() + " is not available");
				}
			} else {
				System.out.println("please enter valid input");
			}

			System.out.println(Constants.ASKING_FOR_MORE_ORDER);
			choice = scan.next().charAt(0);
		} while (choice == 'y' || choice == 'Y');

		if (count > 0) {
			order = orderService.submitOrder(order, orderList);

			orderView.viewOrder(order, orderList);
		} else {
			System.out.println("you not order any item");
		}
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
		} else {
			System.out.println(Constants.ORDER_NOT_EXIST);
		}
	}

}
