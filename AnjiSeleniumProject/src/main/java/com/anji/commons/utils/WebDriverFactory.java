package com.anji.commons.utils;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



/**
 * Factory pattern to get the driver reference based on the browser input type
 * @author anji.boddupally
 *
 */
public class WebDriverFactory {

	private static WebDriver driver;
	
	public static WebDriver getWebDriverInstance(String browserName) {

		//File file = null;
		URL resource = WebDriverFactory.class.getResource("/drivers");
		if (getOSType().indexOf("Win") >= 0) {

			switch (browserName.toLowerCase()) {
			case "ie":
				// Place the IE driver in /resouce/driver folder and provide the path here
				//System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				driver = new InternetExplorerDriver();
				break;
			case "firefox":
					driver = new FirefoxDriver();
				break;
			case "chrome":
				try {
					Path path = Paths.get(resource.toURI());
					String filePath = path.getParent().getParent().getParent()
							+ "\\src\\main\\resources\\drivers\\chromedriver.exe";
					System.out.println("chrome driver path is:\t" + filePath);
					System.setProperty("webdriver.chrome.driver", filePath);
					driver = new ChromeDriver();
					break;
				} catch (URISyntaxException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} else if (getOSType().indexOf("Mac") >= 0) {

			switch (browserName.toLowerCase()) {
			case "firefox":
				Path path1;
				try {
					path1 = Paths.get(resource.toURI());
					String filePath1 = path1.getParent().getParent().getParent()
							+ "//src//main//resources//drivers//geckodriver";
					System.out.println("ff driver path is:\t" + filePath1);
					System.setProperty("webdriver.gecko.driver", filePath1);
					driver = new FirefoxDriver();
					break;
				} catch (URISyntaxException e1) {
					
				}
				
			case "chrome":
				try {
					Path path = Paths.get(resource.toURI());
					String filePath = path.getParent().getParent().getParent()
							+ "//src//main//resources//drivers//chromedriver";
					System.out.println("chrome driver path is:\t" + filePath);
					System.setProperty("webdriver.chrome.driver", filePath);
					driver = new ChromeDriver();
					break;
				} catch (URISyntaxException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} else {
			// Do nothing at this moment
		}
		return driver;
	}

	private static String getOSType() {
		return System.getProperty("os.name");
	}
	
}
