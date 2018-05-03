package com.anji.commons.utils;

import java.io.IOException;
import java.util.Properties;


/**
 * Application Util which provide useful methods to cater the test
 * @author anji.boddupally
 *
 */
public class ApplicationTestUtil {
	
	static String getOSType() {
		return System.getProperty("os.name");
	}
	
	private static Properties getProperties (String propertiesFile) {

		Properties properties = new Properties();
		
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesFile));
		} catch (IOException e) {
			// Log the error
		}
		
		return properties;
	}
	
	private static Properties getApplicationProperties() {
		return getProperties ("application.properties");
	}
	
	public static String getBrowserName() {
		Properties properties = getApplicationProperties(); 
		return properties.getProperty ("browser").toLowerCase();	
	}

	public static String getAppBaseUrl() {
		Properties properties = getApplicationProperties(); 
		return properties.getProperty ("app.url").toLowerCase();	
	}
	
	public static void quitDriver() {
		WebDriverManager.getDriver().quit();
	}
	
	public static String getApplicationUrl() {
		return WebDriverManager.getDriver().getCurrentUrl();
	}
}
