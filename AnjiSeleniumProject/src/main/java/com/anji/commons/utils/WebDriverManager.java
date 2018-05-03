package com.anji.commons.utils;

import org.openqa.selenium.WebDriver;

/**
 * This class is to make Web Driver instance as thread safe.
 * Web Driver is not thread safe and we have to make it thread safe so that we will not get into
 * any troubles when we run our tests in parallel
 * @author Anji Boddupally 
 */

public class WebDriverManager {
	private static WebDriver driver = null;
	static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		String browserName = System.getProperty("browserName");
		if (browserName == null) {
			browserName = "firefox";
		} else {
			browserName = browserName.toLowerCase();
		}
		if(driver == null) {
			driver = WebDriverFactory.getWebDriverInstance(browserName);
			driver.manage().window().maximize();
		}
				
		setDriver(driver);
		return webDriver.get();
	}

	static void setDriver(WebDriver driver) {
		webDriver.set(driver);
	}

	public static void quitDriver() {
		if (webDriver.get() != null) {
			webDriver.get().quit();
		}
	}
}

