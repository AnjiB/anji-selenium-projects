package com.anji.commons.ui.interfaces;

public interface IText extends IWebElement {

	String getText() throws Exception;

	IText assertTextEqualsTo(String stringToAssert) throws Exception;

	IText assertTextContains(String stringToAssert) throws Exception;
}
