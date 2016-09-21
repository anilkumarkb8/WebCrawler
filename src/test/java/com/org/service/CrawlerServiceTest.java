
package com.org.service;

import java.util.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CrawlerServiceTest {

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
	public void testSearchForValidUrl() {
		String url = "http://wiprodigital.com/";
		Set<String> crawlSet = crawlService.search(url);
		Assert.assertNotNull(crawlSet);
	}

	@Test
	public void testSearchForInvalidUrl() {

		String url = "http://wiprodital.com/";
		Set<String> crawlSet = crawlService.search(url);

		Assert.assertEquals(1, crawlSet.size());

	}

}