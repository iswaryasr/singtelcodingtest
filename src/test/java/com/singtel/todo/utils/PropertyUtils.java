package com.singtel.todo.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.log4testng.Logger;

public class PropertyUtils {
	
	private static Logger logger = Logger.getLogger(PropertyUtils.class);


	private static final String CONFIG_PATH = "src/test/resources/config.properties";

	static Properties properties;
	static FileReader reader;

	public static void loadProperties() {
		try {
			properties = new Properties();
			reader = new FileReader(CONFIG_PATH);
			properties.load(reader);
			logger.info("properties loaded successfully");
		} catch (IOException e) {

		}
	}

	public static String getPropertyByName(String name) {
		return properties.getProperty(name).toLowerCase();
	}

}
