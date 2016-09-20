package com.org.service;

import java.util.*;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CrawlerTest {

	private CrawlerService crawlService;

	// Object Instantiate 
	@Before
	public void setUp() {
		crawlService = new CrawlerService();
	}

	@After
	public void exit() {
		crawlService = null;
	}

	@Test
	public void testSearchWithoutNull() {

		String url = "http://wiprodigital.com/";
		Set<String> crawlSet = crawlService.search(url);
		Assert.assertNotNull(crawlSet);
	}
}
