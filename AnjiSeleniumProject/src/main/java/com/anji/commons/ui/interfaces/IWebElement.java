package com.anji.commons.ui.interfaces;

public interface IWebElement {
	String getAttribute(String attribute) throws Exception;

	IWebElement assertDisplayed(long durationToWait) throws Exception;

	IWebElement assertNotDisplayed(long durationToWait) throws Exception;

	IWebElement assertEnabled(long durationToWait) throws Exception;

	IWebElement assertNotEnabled(long durationToWait) throws Exception;

	void printLogs() throws Exception;

	default IWebElement assertDisplayed() throws Exception {
		return assertDisplayed(60L);
	}

	default IWebElement assertNotDisplayed() throws Exception {
		return assertNotDisplayed(3L);
	}

	default IWebElement assertEnabled() throws Exception {
		return assertEnabled(30L);
	}

	default IWebElement assertNotEnabled() throws Exception {
		return assertNotEnabled(3L);
	}

	boolean isDisplayed(long durationToWait) throws Exception;

	boolean isPresent(long durationToWait) throws Exception;

	boolean isEnabled(long durationToWait) throws Exception;

	boolean isDisplayed() throws Exception;

	boolean isPresent() throws Exception;

	boolean isEnabled() throws Exception;

}
