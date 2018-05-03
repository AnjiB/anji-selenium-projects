package com.anji.commons.ui.interfaces;

public interface IButton extends IText {

	/**
	 * Clicks by selenium webElement.click()
	 */
	void click() throws Exception;

	/**
	 * doubleClicking button by Actions api selenium
	 */
	void doubleClick() throws Exception;

	/**
	 * Execute mouse click(left) event through javaScript
	 */
	void mouseClickJS() throws Exception;

	IWebElement assertButtonSelected() throws Exception;

	IWebElement assertButtonNotSelected() throws Exception;

	/**
	 * Clicks an element through console script
	 * <p>
	 * Ex: document.querySelector('#id').click() is translated to executable script as "return arguments[0].click()"
	 */

	void clickByConsoleScript() throws Exception;
}
