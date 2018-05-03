package com.anji.google.ui.tests;

import org.assertj.core.api.Assertions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.anji.commons.utils.ApplicationTestUtil;
import com.anji.google.ui.util.GoogleUIUtil;

public class GoogleUITest {

	private static GoogleUIUtil googleUIUtil;
	
	@BeforeClass
	public static void setUp() {
		googleUIUtil = new GoogleUIUtil();
	}
	
	@Test
	public void testGoogleSearch() throws Exception {
		googleUIUtil.launchGoogle();
		googleUIUtil.toGoogleSearchUtil().searchBox().setText("selenium");
		googleUIUtil.toGoogleSearchUtil().searchButton().click();
		googleUIUtil.toGoogleSearchUtil().assertResultsReturnedInSearch();
		
	}
	
	// SignIn button will be clicked using js function instead of native selenium click api
	
	@Test
	public void testGmailUrl() throws Exception {
		googleUIUtil.launchGoogle();
		googleUIUtil.toGoogleHeader().gmail().click();
		Assertions.assertThat(ApplicationTestUtil.getApplicationUrl()).contains("gmail");
		
	}
	
	@AfterClass
	public static void cleanUp() {
		ApplicationTestUtil.quitDriver();
	}
}
