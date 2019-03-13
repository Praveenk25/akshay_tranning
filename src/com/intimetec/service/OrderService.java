package com.intimetec.service;

import java.util.ArrayList;

import com.intimetec.entity.Order;
import com.intimetec.entity.OrderItem;

public interface OrderService {

	Order submitOrder(Order order, ArrayList<OrderItem> orderList);

	Order getOrder(int orderNo);

	ArrayList<OrderItem> getOrderList(int orderNo);

}
