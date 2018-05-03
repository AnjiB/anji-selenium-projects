package com.anji.commons.ui.impl;


import org.assertj.core.api.Assertions;

import com.anji.commons.ui.interfaces.ILink;
import com.anji.commons.ui.interfaces.IText;

public abstract class AbstractLinkImpl extends AbstractButtonImpl implements ILink {

	@Override
	public String getLinkUrl() throws Exception {
		return getWebElementInDomWithWait().getAttribute("href");
	}

	@Override
	public ILink assertLinkUrl(String urlToAssert) throws Exception {
		Assertions.assertThat(getLinkUrl()).contains(urlToAssert);
		return this;
	}

	@Override
	public String getText() throws Exception {
		return getWebElementInDomWithWait().getText();
	}

	@Override
	public IText assertTextEqualsTo(String stringToAssert) throws Exception {
		Assertions.assertThat(getText()).isEqualTo(stringToAssert);
		return this;
	}

	@Override
	public IText assertTextContains(String stringToAssert) throws Exception {
		Assertions.assertThat(getText()).contains(stringToAssert);
		return this;
	}
}
