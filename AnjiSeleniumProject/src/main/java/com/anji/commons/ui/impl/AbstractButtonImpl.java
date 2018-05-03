package com.anji.commons.ui.impl;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.anji.commons.ui.interfaces.IButton;
import com.anji.commons.ui.interfaces.IWebElement;
import com.anji.commons.utils.WebDriverManager;

public abstract class AbstractButtonImpl extends AbstractTextImpl implements IButton {

	@Override
	public void click() throws Exception {
		getWebElementEnabledWithWait().click();
	}

	@Override
	public void mouseClickJS() throws Exception {
		String script = "var theEvent = document.createEvent(\"MouseEvent\"); "
				+ "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null); "
				+ "arguments[0].dispatchEvent(theEvent)";
		((JavascriptExecutor) WebDriverManager.getDriver()).executeScript(script, getWebElement());
	}

	@Override
	public void clickByConsoleScript() throws Exception {
		String script = "return arguments[0].click()";
		((JavascriptExecutor) WebDriverManager.getDriver()).executeScript(script, getWebElement());
	}

	@Override
	public void doubleClick() throws Exception {
		Actions actions = new Actions(WebDriverManager.getDriver());
		actions.doubleClick(getWebElementEnabledWithWait()).perform();
	}
	
	@Override
	public IWebElement assertButtonSelected() throws Exception {
		String classAttribute = getAttribute("class");
		Assertions.assertThat(classAttribute).contains("selected").as("Button is not selected");
		return this;
	}
	
	@Override
	public IWebElement assertButtonNotSelected() throws Exception {
		String classAttribute = getAttribute("class");
		Assertions.assertThat(classAttribute).doesNotContain("selected").as("Button is selected");
		return this;
	}

}
