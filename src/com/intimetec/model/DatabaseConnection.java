package com.intimetec.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.intimetec.configuration.ConfigurationReader;
import com.intimetec.constants.Constants;

public class DatabaseConnection {
	private static Connection connection = null;

	static Connection getConnection() {

		if (connection == null) {
			ConfigurationReader configurationReader = new ConfigurationReader();
			Properties properties = configurationReader.getProperties(Constants.DB_FILE);

			try {
				if (!LoadDriver.isDriverLoaded()) {
					LoadDriver.loadDriver();
				}
				connection = DriverManager.getConnection(properties.getProperty("url"),
						properties.getProperty("userName"), properties.getProperty("password"));

			} catch (

			SQLException e) {
				return null;
			} catch (Exception e) {
				return null;
			}
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
				connection = null;
			}
		} catch (SQLException e) {

		}
	}

}
