package com.anji.commons.ui.impl;



import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.anji.commons.ui.interfaces.ITextBox;


public abstract class AbstractTextBoxImpl extends AbstractTextImpl implements ITextBox {


	@Override
	public void setText(String value) throws Exception {
		WebElement element = getWebElementEnabledWithWait();
		element.clear();
		element.sendKeys(value);
	}

	@Override
	public void sendKeys(Keys keys) throws Exception {
		WebElement element = getWebElementEnabledWithWait();
		element.sendKeys(keys);
	}

	@Override
	public String getText() throws Exception {
		return getWebElementEnabledWithWait().getAttribute("value");
	}

	@Override
	public ITextBox assertMandatory() throws Exception {
		Assertions.fail("Not yet implemented");
		return this;
	}

	@Override
	public ITextBox assertNotMandatory() throws Exception {
		Assertions.fail("Not yet implemented");
		return this;
	}
}
