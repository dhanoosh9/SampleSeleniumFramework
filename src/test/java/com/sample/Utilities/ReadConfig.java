package com.sample.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	static Properties prop;
	File src = new File("./PropertiesFile/config.properties");

	public String getGlobalValue(String key) {
		try {
			FileInputStream input = new FileInputStream(src);
			prop = new Properties();
			prop.load(input);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
			e.getStackTrace();
		}
		return prop.getProperty(key);
	}

}
