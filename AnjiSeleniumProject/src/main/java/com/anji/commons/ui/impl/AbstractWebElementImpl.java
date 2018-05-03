package com.anji.commons.ui.impl;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.anji.commons.ui.interfaces.IWebElement;

public abstract class AbstractWebElementImpl implements IWebElement {

	private static final Logger LOGGER = Logger.getLogger(AbstractWebElementImpl.class);

	private static final long DEFAULT_WAIT_DURATION = 30;

	@Override
	public String getAttribute(String attribute) throws Exception {
		if (isPresent(DEFAULT_WAIT_DURATION)) {
			return getWebElement().getAttribute(attribute);
		}
		return null;
	}

	@Override
	public IWebElement assertDisplayed(long durationToWait) throws Exception {
		Assertions.assertThat(isDisplayed(durationToWait))
				.as("Element is not displayed").isTrue();
		return this;
	}

	@Override
	public IWebElement assertNotDisplayed(long durationToWait) throws Exception {
		Assertions.assertThat(isDisplayed(durationToWait))
				.as("Element is displayed").isFalse();
		return this;
	}

	@Override
	public IWebElement assertEnabled(long durationToWait) throws Exception {
		Assertions.assertThat(isEnabled(durationToWait))
				.as("Element is not enabled").isTrue();
		return this;
	}

	@Override
	public IWebElement assertNotEnabled(long durationToWait) throws Exception {
		Assertions.assertThat(isEnabled(durationToWait))
				.as("Element is enabled").isFalse();
		return this;
	}

	@Override
	public void printLogs() throws Exception {
		Assertions.fail("Not yet implemented");
	}

	@Override
	public boolean isDisplayed(long durationToWait) throws Exception {
		WebElement element = getWebElement();
		LOGGER.info(String.format("### Waiting to check if element is displayed, %s ###", element));
		if (isPresent(durationToWait)) {
			try {
				new FluentWait<>(element).withTimeout(durationToWait, TimeUnit.SECONDS)
						.ignoring(StaleElementReferenceException.class)
						.ignoring(NoSuchElementException.class)
						.pollingEvery(500, TimeUnit.MILLISECONDS)
						.until( input -> getWebElement().isDisplayed());
				return getWebElement().isDisplayed();
			} catch (TimeoutException ex) {
				LOGGER.info("### Element is not displayed ###", ex);
				return false;
			}
		} else {
			LOGGER.info("### Element is not present in DOM, hence not displayed ###");
			return false;
		}
	}

	@Override
	public boolean isPresent(long durationToWait) throws Exception {
		WebElement element = getWebElement();
		LOGGER.info(String.format("### Waiting to check if element is present in DOM, %s ###", element));
		try {
			new FluentWait<>(element).withTimeout(durationToWait, TimeUnit.SECONDS)
					.ignoring(StaleElementReferenceException.class)
					.pollingEvery(500, TimeUnit.MILLISECONDS)
					.until( input -> {
						try {
							return getWebElement().getTagName() != null;
						} catch (NoSuchElementException ex) {
							LOGGER.info("### Element is not present in DOM, going to try ###");
							return false;
						}
					});
			LOGGER.info("### Element is present in DOM ###");
			return true;
		} catch (TimeoutException ex) {
			LOGGER.info("### Element is not present in DOM ###", ex);
			return false;
		} 
	}

	@Override
	public boolean isEnabled(long durationToWait) throws Exception {
		WebElement element = getWebElement();
		LOGGER.info(String.format("### Waiting to check if element is enabled %s ###", element));
		if (isDisplayed(durationToWait)) {
			try {
				new FluentWait<>(element).withTimeout(durationToWait, TimeUnit.SECONDS)
						.ignoring(StaleElementReferenceException.class)
						.ignoring(NoSuchElementException.class)
						.pollingEvery(500, TimeUnit.MILLISECONDS)
						.until( input -> getWebElement().isEnabled());
				return getWebElement().isEnabled();
			} catch (TimeoutException ex) {
				LOGGER.info("### Element is not enabled ###", ex);
				return false;
			}
		} else {
			Assertions.fail("Element is not present in DOM" );
			return false;
		}
	}

	@Override
	public boolean isDisplayed() throws Exception {
		return isDisplayed(DEFAULT_WAIT_DURATION);
	}

	@Override
	public boolean isPresent() throws Exception {
		return isPresent(DEFAULT_WAIT_DURATION);
	}

	@Override
	public boolean isEnabled() throws Exception {
		return isEnabled(DEFAULT_WAIT_DURATION);
	}

	/**
	 * It will wait until an element is present in DOM, but it does not care if its displayed
	 */
	protected WebElement getWebElementInDomWithWait() throws Exception {
		if (isPresent(DEFAULT_WAIT_DURATION)) {
			return getWebElement();
		} else {
			Assertions.fail("Element is not present in DOM");
			return null;
		}
	}

	/**
	 * It will wait until an element is present in DOM as well as displayed
	 */
	protected WebElement getWebElementEnabledWithWait() throws Exception {
		if (isEnabled(DEFAULT_WAIT_DURATION)) {
			return getWebElement();
		} else {
			Assertions.fail("Element is not enabled");
			return null;
		}
	}

	protected abstract WebElement getWebElement();
}
