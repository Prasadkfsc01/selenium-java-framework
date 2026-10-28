package com.sdet.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static final Properties properties = new Properties();

	private ConfigManager() {
		// Prevent object creation
	}

//	static just runs the piece of code with out calling when we use static. This code, gets the config.properties file stores in input variable. 
	static {

		try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties")) {
			if (input == null) {
				throw new IllegalStateException("config.properties file not found ");
			}
			properties.load(input);

		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static String get(String key) {

		// 1. Check Maven/JVM system property first
		String systemValue = System.getProperty(key);

		if (systemValue != null && !systemValue.isBlank()) {
			return systemValue.trim();
		}

		// 2. Fall back to config.properties
		String value = properties.getProperty(key);

		if (value == null || value.isBlank()) {
			throw new IllegalArgumentException("Missing configuration property: " + key);
		}

		return value.trim();
	}

}
