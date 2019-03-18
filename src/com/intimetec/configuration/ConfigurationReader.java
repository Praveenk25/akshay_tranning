package com.intimetec.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.intimetec.constants.Constants;

public class ConfigurationReader {

	public Properties getProperties(String fileName) {
		Properties properties;

		properties = new Properties();
		try {
			FileInputStream reader = new FileInputStream(Constants.CONFIGURATION_LOCATION + fileName);
			properties.load(reader);
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println(Constants.DB_CONNECTION_ISSUE);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(Constants.DB_CONNECTION_ISSUE);
		}

		return properties;

	}

}
