package com.intimetec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.intimetec.constants.Constants;
import com.intimetec.entity.Order;
import com.intimetec.entity.OrderItem;

public class OrderPersistentImpl implements OrderPersistent {

	public void submitOrder(Order order, ArrayList<OrderItem> orderList) {
		CreateSessionFactory createSessionFactory = new CreateSessionFactory();

		Session session = createSessionFactory.getSession();

		Transaction transaction = session.beginTransaction();

		int orderNo = (int) session.save(order);

		for (OrderItem orderItem : orderList) {

			orderItem.setOrder(order);

			session.save(orderItem);
		}

		transaction.commit();

		session.close();

	}

	public Order getOrder(int orderNo) {
		CreateSessionFactory createSessionFactory = new CreateSessionFactory();

		Session session = createSessionFactory.getSession();
		
		try {
		return session.get(Order.class, orderNo);
		}
		catch(Exception e) {
			return null;
		}
	}

	public ArrayList<OrderItem> getOrderList(int orderNo) {
		ArrayList<OrderItem> orderList = new ArrayList<OrderItem>();

		ResultSet resultSet = null;

		Connection connection = DatabaseConnection.getConnection();

		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(Constants.GET_ORDER_ITEM);
				preparedStatement.setInt(1, orderNo);
				resultSet = preparedStatement.executeQuery();

			} catch (SQLException e) {
				System.out.println(Constants.DB_CONNECTION_ISSUE);
				System.out.println(e.getMessage());
			}

			try {
				while (resultSet.next()) {
					OrderItem orderItem = new OrderItem();
					orderItem.setItemName(resultSet.getString("orderItem"));
					orderItem.setPrice(resultSet.getFloat("price"));
					orderItem.setQuantity(resultSet.getInt("quantity"));

					orderList.add(orderItem);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				return null;
			} finally {
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						System.out.println(Constants.DB_CONNECTION_ISSUE);
						System.out.println(e.getMessage());
					}
				}
			}

			return orderList;
		} else {
			return null;
		}

	}

}
