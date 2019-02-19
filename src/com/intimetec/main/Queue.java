package com.intimetec.main;
import java.util.ArrayDeque;

public class Queue {
	public static ArrayDeque<Order> orderqueue = new ArrayDeque<Order>();

	public static void queue(Order order) {
		orderqueue.add(order); // adding the order into the queue
		System.out.println("Your order is submitted & your order no is : " + Order.ordernumber);
	}
}
