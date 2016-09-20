package com.org.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UrlValidatorServiceTest {

	private UrlValidatorService urlValidatorService;

	// Object Instantiate
	@Before
	public void setUp() {
		urlValidatorService = new UrlValidatorService();
	}

	@After
	public void exit() {
		urlValidatorService = null;
	}

	@Test
	public void testValidatorforTrue() {

		String url = "http://wiprodigital.com/";
		Assert.assertTrue(urlValidatorService.isUrlValid(url));

	}
	
	@Test
	public void testValidatorforFalse1() {

		String url = "http//wiprodigital.com/";
		Assert.assertFalse(urlValidatorService.isUrlValid(url));

	}
	
	@Test
	public void testValidatorforFalse2() {

		String url = "http://wiprodigi tal.com/";
		Assert.assertFalse(urlValidatorService.isUrlValid(url));

	}
	
	@Test
	public void testValidatorforEmptyString() {

		String url = "";
		Assert.assertFalse(urlValidatorService.isUrlValid(url));

	}
}