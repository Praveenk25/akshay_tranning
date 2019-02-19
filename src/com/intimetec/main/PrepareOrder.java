package com.intimetec.main;
import java.util.ArrayList;

class Order {
	static int ordernumber = 0;
	int orderno = 0;
	ArrayList<Menu> order = new ArrayList<Menu>();

	public Order() {
		orderno = ++ordernumber;
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
