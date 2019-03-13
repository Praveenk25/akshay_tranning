package com.intimetec.model;

import java.util.ArrayList;

import com.intimetec.entity.Order;
import com.intimetec.entity.OrderItem;

public interface OrderPersistent {

	void submitOrder(Order order, ArrayList<OrderItem> orderList);

	public Order getOrder(int OrderNo);

	public ArrayList<OrderItem> getOrderList(int orderNo);

}
