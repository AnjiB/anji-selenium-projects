package com.anji.commons.ui.interfaces;

import org.openqa.selenium.Keys;

public interface ITextBox extends IText {

	void setText(String value) throws Exception;

	void sendKeys(Keys keys) throws Exception;

	ITextBox assertMandatory() throws Exception;

	ITextBox assertNotMandatory() throws Exception;

}
