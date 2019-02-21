package com.intimetec.main;

import java.util.ArrayList;

class Order {
	static int orderNumber = 0;
	int orderNo = 0;
	ArrayList<Menu> order = new ArrayList<Menu>();

	public Order() {
		orderNo = ++orderNumber;
	}
}

public class PrepareOrder {
	public void add(ArrayList<Menu> orderlist) {// make the order object
		Order order = new Order();

		for (Menu m : orderlist) {
			order.order.add(m);
		}
		Queue.queue(order);
	}
}
