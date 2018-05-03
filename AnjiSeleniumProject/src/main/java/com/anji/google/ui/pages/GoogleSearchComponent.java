package com.anji.google.ui.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.anji.commons.utils.WebDriverManager;

public class GoogleSearchComponent {
	
	@FindBy(css = "input[value='Google Search']")
	private WebElement searchButton;
	
	@FindBy(css = "#lst-ib")
	private WebElement searchBox;
	
	@FindBy(css = "#search #ires div.srg div")
	private List<WebElement> searchResults;
	
	
	public GoogleSearchComponent() {
		PageFactory.initElements(new AjaxElementLocatorFactory(WebDriverManager.getDriver(), 5), this);
	}


	public WebElement getSearchButton() {
		return searchButton;
	}


	public WebElement getSearchBox() {
		return searchBox;
	}


	public List<WebElement> getSearchResults() {
		return searchResults;
	}
}
