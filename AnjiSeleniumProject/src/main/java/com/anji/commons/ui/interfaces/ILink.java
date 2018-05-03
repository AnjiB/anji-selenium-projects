package com.anji.commons.ui.interfaces;

public interface ILink extends IButton, IText {

	/**
	 * It returns URL of the displayed link, not the displayed link text
	 */
	String getLinkUrl() throws Exception;

	ILink assertLinkUrl(String urlToAssert) throws Exception;

}
