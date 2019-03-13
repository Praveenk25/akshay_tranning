package com.intimetec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import com.intimetec.constants.Constants;
import com.intimetec.entity.MenuItem;

public class MenuPersistentImpl implements MenuPersistent {

	public ArrayList<MenuItem> getMenuList() {
		HashSet<MenuItem> menuItems = new HashSet<MenuItem>();

		ArrayList<MenuItem> menuList = new ArrayList<MenuItem>();

		Connection connection = DatabaseConnection.getConnection();

		Statement statement = null;

		ResultSet resultSet = null;

		if (connection != null) {
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(Constants.SELECT_MENU_ITEMS);

				while (resultSet.next()) {
					MenuItem menuItem = new MenuItem();
					menuItem.setItemName(resultSet.getString("itemName"));
					menuItem.setPrice(resultSet.getFloat("price"));
					menuItem.setAvailable(resultSet.getBoolean("availability"));
					menuItems.add(menuItem);
				}
			} catch (SQLException e) {
				System.out.println("connectivity issue");
			} finally {
				try {
					resultSet.close();
					statement.close();
				} catch (SQLException e) {
					System.out.println("connectivity issue");
				} catch (Exception e) {
					System.out.println("connectivity issue");
				}
			}
		}

		menuList.addAll(menuItems);
		return menuList;

	}

	public void addMenuItem(MenuItem menuItem) {
		Connection connection = DatabaseConnection.getConnection();

		PreparedStatement preparedStatement = null;

		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(Constants.ADD_MENU_ITEM);

				preparedStatement.setString(1, menuItem.getItemName());
				preparedStatement.setString(2, String.valueOf(menuItem.getPrice()));
				preparedStatement.setString(3, String.valueOf((menuItem.isAvailable() ? 1 : 0)));

				preparedStatement.execute();
			} catch (SQLException e) {
				System.out.println("not added connectivity issue");
				System.out.println(e.getMessage());
			} finally {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}

		}
	}

	public void deleteMenuItem(String itemName) {
		Connection connection = DatabaseConnection.getConnection();

		PreparedStatement preparedStatement = null;

		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(Constants.DELETE_MENU_ITEM);

				preparedStatement.setString(1, itemName);

				preparedStatement.execute();
			} catch (SQLException e) {
				System.out.println("not deleted connectivity issue");
				System.out.println(e.getMessage());
			} finally {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}

	public void updateItem(MenuItem menuItem) {
		Connection connection = DatabaseConnection.getConnection();

		PreparedStatement preparedStatement = null;

		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(Constants.UPDATE_MENU_ITEM);

				preparedStatement.setString(1, String.valueOf(menuItem.getPrice()));
				preparedStatement.setString(2, String.valueOf((menuItem.isAvailable() ? 1 : 0)));
				preparedStatement.setString(3, menuItem.getItemName());

				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("not updated connectivity issue");
				System.out.println(e.getMessage());
			} finally {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}

}
