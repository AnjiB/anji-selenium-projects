package com.anji.google.ui.util;

import org.openqa.selenium.WebDriver;

import com.anji.commons.utils.ApplicationTestUtil;
import com.anji.commons.utils.WebDriverManager;
import com.google.inject.Singleton;

@Singleton
public class GoogleUIUtil {
	
	private GoogleHeaderUtil googleHeaderUtil;
	
	private GoogleSearchUtil googleSearchUtil;

	public void launchGoogle() {
		WebDriver driver = WebDriverManager.getDriver();
		String url = ApplicationTestUtil.getAppBaseUrl();
		driver.get(url);
	}
	
	public GoogleHeaderUtil toGoogleHeader() {
		googleHeaderUtil = GoogleHeaderUtil.getInstance(this);
		return googleHeaderUtil;
	}
	
	public GoogleSearchUtil toGoogleSearchUtil() {
		googleSearchUtil = GoogleSearchUtil.getInstance(this);
		return googleSearchUtil;
	}
	
}
