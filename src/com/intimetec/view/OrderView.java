package com.intimetec.view;

import java.util.ArrayList;

import com.intimetec.entity.Order;
import com.intimetec.entity.OrderItem;

public interface OrderView {
	void viewOrder(Order order, ArrayList<OrderItem> orderList);
}
