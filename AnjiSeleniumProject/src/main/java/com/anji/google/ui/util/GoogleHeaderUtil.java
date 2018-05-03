package com.anji.google.ui.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.anji.commons.ui.impl.AbstractButtonImpl;
import com.anji.commons.ui.impl.AbstractLinkImpl;
import com.anji.commons.ui.interfaces.IButton;
import com.anji.commons.ui.interfaces.ILink;
import com.anji.commons.utils.WebDriverManager;
import com.anji.google.ui.pages.GoogleHeaderComponent;

public class GoogleHeaderUtil {
	
	private GoogleHeaderUtil() {
		
	}
	
	public static GoogleHeaderUtil getInstance(GoogleUIUtil util) {
		return new GoogleHeaderUtil();
	}
	
	private GoogleHeaderComponent getComponent() {
		return new GoogleHeaderComponent();
	}
	
	private IButton buttonImpl(WebElement element) {
		return new AbstractButtonImpl() {
			
			@Override
			protected WebElement getWebElement() {
				return element;
			}
			
			// I am overriding the click method 
			@Override
			public void click() throws Exception {
				String script = "return arguments[0].click()";
				((JavascriptExecutor) WebDriverManager.getDriver()).executeScript(script, getWebElement());
			}
			
		};
	}
	
	public IButton signIn() {
		return buttonImpl(getComponent().getSignInButton());
	}
	
	private ILink linkImpl(WebElement element) {
		return new AbstractLinkImpl() {
			
			@Override
			protected WebElement getWebElement() {
				return element;
			}
		};
	}
	
	public ILink gmail() {
		return linkImpl(getComponent().getGmailLink());
	}
	
	public ILink images() {
		return linkImpl(getComponent().getImagesLink());
	}
}
