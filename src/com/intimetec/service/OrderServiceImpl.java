package com.intimetec.service;

import java.sql.Time;
import java.util.ArrayList;

import com.intimetec.entity.Order;
import com.intimetec.entity.OrderItem;
import com.intimetec.model.OrderPersistent;
import com.intimetec.model.OrderPersistentImpl;

public class OrderServiceImpl implements OrderService {
	OrderPersistent orderPersistent = new OrderPersistentImpl();

	public Order submitOrder(Order order, ArrayList<OrderItem> orderList) {
		float totalAmount = 0;

		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		order.setDate(date);

		order.setTime(new Time(date.getTime()));

		for (OrderItem orderItem : orderList) {
			totalAmount += (orderItem.getPrice() * orderItem.getQuantity());
		}

		order.setTotalAmount(totalAmount);

		orderPersistent.submitOrder(order, orderList);

		return order;
	}

	public Order getOrder(int OrderNo) {

		return orderPersistent.getOrder(OrderNo);
	}

	public ArrayList<OrderItem> getOrderList(int orderNo) {

		return orderPersistent.getOrderList(orderNo);
	}

}
