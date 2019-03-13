package com.intimetec.model;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class LoadDriver {
	static boolean flag = false;

	static boolean isDriverLoaded() {
		return flag;
	}

	static void loadDriver() throws SQLException {
		DriverManager.registerDriver(new Driver());

		flag = true;

	}

}
