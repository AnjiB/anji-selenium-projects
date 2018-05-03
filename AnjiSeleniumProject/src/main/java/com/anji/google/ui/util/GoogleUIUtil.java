package com.anji.google.ui.util;

import org.openqa.selenium.WebDriver;

import com.anji.commons.utils.ApplicationTestUtil;
import com.anji.commons.utils.WebDriverManager;
import com.google.inject.Singleton;

@Singleton
public class GoogleUIUtil {

	public void launchGoogle() {
		WebDriver driver = WebDriverManager.getDriver();
		String url = ApplicationTestUtil.getAppBaseUrl();
		driver.get(url);
	}
	
	public GoogleHeaderUtil toGoogleHeader() {
		return GoogleHeaderUtil.getInstance(this);
	}
	
	public GoogleSearchUtil toGoogleSearchUtil() {
		return GoogleSearchUtil.getInstance(this);
	}
	
}
