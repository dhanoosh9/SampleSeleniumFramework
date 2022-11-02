package com.sample.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	static Properties prop;
	File src = new File("./PropertiesFile/config.properties");

//	public ReadConfig() {
//
//		File src = new File("./PropertiesFile/config.properties");
//
//		try {
//			FileInputStream input = new FileInputStream(src);
//			prop = new Properties();
//			prop.load(input);
//		} catch (Exception e) {
//			System.out.println("Exception is " + e.getMessage());
//			e.getStackTrace();
//		}
//
//	}
	
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

	public String getbrowserName() {
		String browserName = prop.getProperty("browser");
		return browserName;
	}

	public String getApplicationURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}

	public String getUsername() {
		String username = prop.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}

	public int getTimeout() {
		String time = prop.getProperty("timeout");
		int timeout = Integer.parseInt(time);
		return timeout;
	}

}
