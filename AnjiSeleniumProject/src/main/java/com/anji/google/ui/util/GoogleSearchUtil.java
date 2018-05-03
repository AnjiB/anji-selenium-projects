package com.anji.google.ui.util;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;

import com.anji.commons.ui.impl.AbstractButtonImpl;
import com.anji.commons.ui.impl.AbstractTextBoxImpl;
import com.anji.commons.ui.interfaces.IButton;
import com.anji.commons.ui.interfaces.ITextBox;
import com.anji.google.ui.pages.GoogleSearchComponent;

public class GoogleSearchUtil {

	private GoogleSearchUtil() {
		
	}
	
	public static GoogleSearchUtil getInstance(GoogleUIUtil util) {
		return new GoogleSearchUtil();
	}
	
	private GoogleSearchComponent getComponent() {
		return new GoogleSearchComponent();
	}
	
	private IButton buttonImpl(WebElement element) {
		return new AbstractButtonImpl() {
			
			@Override
			protected WebElement getWebElement() {
				return element;
			}
		};
	}
	
	private ITextBox boxImpl(WebElement element) {
		return new AbstractTextBoxImpl() {
			
			@Override
			protected WebElement getWebElement() {
				return element;
			}
		};
	}
	
	public ITextBox searchBox() {
		return boxImpl(getComponent().getSearchBox());
	}
	
	public IButton searchButton() {
		return buttonImpl(getComponent().getSearchButton());
	}
	
	public void assertResultsReturnedInSearch() {
		List<WebElement> results = getComponent().getSearchResults();
		Assertions.assertThat(results).isNotEmpty();
		Assertions.assertThat(results.size()).isGreaterThan(0);
	}
}
