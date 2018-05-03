package com.anji.google.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.anji.commons.utils.WebDriverManager;

public class GoogleHeaderComponent {

	@FindBy(partialLinkText = "Gmail")
	private WebElement gmailLink;
	
	@FindBy(linkText = "Images")
	private WebElement imagesLink;
	
	@FindBy(id = "gb_70")
	private WebElement signInButton;
	
	public GoogleHeaderComponent() {
		PageFactory.initElements(new AjaxElementLocatorFactory(WebDriverManager.getDriver(), 5), this);
	}

	public WebElement getGmailLink() {
		return gmailLink;
	}

	public WebElement getImagesLink() {
		return imagesLink;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}
}
