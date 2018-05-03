package com.anji.commons.ui.impl;

import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import com.anji.commons.ui.interfaces.IText;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTextImpl extends AbstractWebElementImpl implements IText {

	private static final Logger LOGGER = Logger.getLogger(AbstractTextImpl.class);

	@Override
	public String getText() throws Exception {
		return getWebElementInDomWithWait().getText();
	}

	@Override
	public IText assertTextEqualsTo(String stringToAssert) throws Exception {
		Assertions.assertThat(waitAndGetText(stringToAssert)).isEqualTo(stringToAssert);
		return this;
	}

	@Override
	public IText assertTextContains(String stringToAssert) throws Exception {
		Assertions.assertThat(waitAndGetText(stringToAssert)).contains(stringToAssert);
		return this;
	}

	private String waitAndGetText(String stringToAssert) throws Exception {
		final String[] text = new String[1];
		try {
		new FluentWait<>(stringToAssert).withTimeout(45, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.until( input -> {
					boolean matchFound = false;
					try {
					text[0] = getText();
					if (text[0].contains(stringToAssert)) {
							LOGGER.info("Match found");
							matchFound = true;
						} else {
						LOGGER.info("Match not found.. trying again Expected:" + stringToAssert + "Actual:"+ text[0]);
						}
					} catch (Exception e) {
						LOGGER.error("Exception ", e);
					}
					return matchFound;
				});
		} catch(TimeoutException e) {
			LOGGER.info("Text present on the page even after waiting for 45 seconds is:\t" + text[0]);
		}
		return text[0];
	}
}
