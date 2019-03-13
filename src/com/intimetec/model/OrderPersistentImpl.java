package com.intimetec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.intimetec.constants.Constants;
import com.intimetec.entity.Order;
import com.intimetec.entity.OrderItem;

public class OrderPersistentImpl implements OrderPersistent {

	public void submitOrder(Order order, ArrayList<OrderItem> orderList) {
		Connection connection = DatabaseConnection.getConnection();

		int orderNo = 0;

		if (connection != null) {
			PreparedStatement preparedStatement = null;

			PreparedStatement statementToGetOrderNo = null;

			PreparedStatement statementToSubmitOrderItems = null;

			ResultSet resultSet = null;

			try {
				preparedStatement = connection.prepareStatement(Constants.ADD_ORDER);

				statementToGetOrderNo = connection.prepareStatement(Constants.GET_ORDER_NO);

				preparedStatement.setString(1, order.getCustomerName());
				preparedStatement.setDate(2, order.getDate());
				preparedStatement.setBoolean(3, false);
				preparedStatement.setFloat(4, order.getTotalAmount());
				preparedStatement.setString(5, order.getMobileNo());
				preparedStatement.setTime(6, order.getTime());

				preparedStatement.executeUpdate();

				statementToGetOrderNo.setString(1, order.getCustomerName());
				statementToGetOrderNo.setString(2, order.getMobileNo());
				statementToGetOrderNo.setTime(3, order.getTime());

				resultSet = statementToGetOrderNo.executeQuery();
				resultSet.next();
				orderNo = resultSet.getInt("OrderNo");

			} catch (SQLException e) {
				System.out.println("connectivity issue order not submitted");
				System.out.println(e.getMessage());
			}

			try {
				statementToSubmitOrderItems = connection.prepareStatement(Constants.ADD_ORDER_ITEM);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			for (OrderItem orderItem : orderList) {
				orderItem.setOrderNo(orderNo);
				try {
					statementToSubmitOrderItems.setInt(1, orderNo);
					statementToSubmitOrderItems.setString(2, orderItem.getItemName());
					statementToSubmitOrderItems.setFloat(3, orderItem.getPrice());
					statementToSubmitOrderItems.setInt(4, orderItem.getQuantity());

					statementToSubmitOrderItems.addBatch();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
			try {
				statementToSubmitOrderItems.executeBatch();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}

		}

	}

	public Order getOrder(int orderNo) {
		Connection connection = DatabaseConnection.getConnection();

		ResultSet resultSet = null;

		Order order = new Order();

		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(Constants.GET_ORDER);
				preparedStatement.setInt(1, orderNo);

				resultSet = preparedStatement.executeQuery();
			} catch (SQLException e) {
				System.out.println("connectivity issue");
				System.out.println(e.getMessage());
			}

		}

		try {
			resultSet.next();
			order.setOrderNo(orderNo);
			order.setCustomerName(resultSet.getString("CustomerName"));
			order.setDate(resultSet.getDate("OrderDate"));
			order.setMobileNo(resultSet.getString("MobileNo"));
			order.setTime(resultSet.getTime("Time"));
			order.setTotalAmount(resultSet.getFloat("TotalAmount"));

			return order;
		} catch (SQLException e) {
			System.out.println(orderNo + "is not exist");
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
				System.out.println("connectivity issue");
				System.out.println(e.getMessage());
			}

			try {
				while (resultSet.next()) {
					OrderItem orderItem = new OrderItem();
					orderItem.setItemName(resultSet.getString("orderItem"));
					orderItem.setOrderNo(resultSet.getInt("orderNo"));
					orderItem.setPrice(resultSet.getFloat("price"));
					orderItem.setQuantity(resultSet.getInt("quantity"));

					orderList.add(orderItem);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				return null;
			}

			return orderList;
		} else {
			return null;
		}

	}

}
