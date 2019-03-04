package com.intimetec.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DatabaseConnection {
	static String url = "jdbc:mysql://localhost:3306/restaurentApp";
	static String userName = "root";
	private static String password = "system";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			return connection;
		}
	}

}
