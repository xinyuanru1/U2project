package com.bdqn.util;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	private static ConfigManager configManager;
	private static Properties properties;
	public ConfigManager(){
		String configManager="database.properties";
		properties = new Properties();
		InputStream in = ConfigManager.class.getClassLoader().getResourceAsStream(configManager);
		try {
			properties.load(in);
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static ConfigManager getInstance(){
		if(configManager == null){
			configManager = new ConfigManager();
		}
		return configManager;
	}
	public String getString(String key){
		return properties.getProperty(key);
	}
}
