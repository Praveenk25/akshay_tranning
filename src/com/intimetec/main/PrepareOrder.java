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
	// make the order object
	public void add(ArrayList<Menu> orderlist) {
		Order order = new Order();

		for (Menu m : orderlist) {
			order.order.add(m);
		}
		Queue.queue(order);
	}
}
