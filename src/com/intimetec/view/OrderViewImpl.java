package com.intimetec.view;

import java.util.ArrayList;

import com.intimetec.entity.Order;
import com.intimetec.entity.OrderItem;

public class OrderViewImpl implements OrderView {

	public void viewOrder(Order order, ArrayList<OrderItem> orderList) {

		System.out.println(order);

		for (OrderItem orderItem : orderList) {
			System.out.println(orderItem);
		}

		System.out.println("Total Amount : " + order.getTotalAmount() + "\n");
	}

}
