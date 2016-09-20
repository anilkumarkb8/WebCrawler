package com.org.service;

import java.util.*;
import java.util.regex.Pattern;

public class CrawlerService {

	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpe?g|png|mp3|mp3|zip|gz))$");
	private Set<String> pagesVisited = new HashSet<String>();
	private List<String> pagesToVisit = new LinkedList<String>();

	/**
	 * Our main launching point for the crawler's functionality. Internally it
	 * creates connections, that make an HTTP request and parse the response
	 * (the web page).
	 * 
	 * @param url
	 *            - The starting point of the crawler
	 * @param urlValidator
	 *            - The the thread which contains the base of URL
	 */
	public Set<String> search(String url) {

		do {
			String currentUrl;
			CustomCrawlerImpl crawler = new CustomCrawlerImpl();
			if (this.pagesToVisit.isEmpty()) {
				currentUrl = url;
				this.pagesVisited.add(url);
			} else {
				currentUrl = this.nextUrl(url);
				if (currentUrl.equals("empty")) {
					
					break;

				}

			}

			boolean status = crawler.crawl(currentUrl);
			if (status) {
				this.pagesToVisit.addAll(crawler.getLinks());
				System.out.println(crawler.getLinks().toString());
			}else{
				System.out.println("Crawl Failed for " + currentUrl);
			}
		} while (this.pagesToVisit.size() > 0);

		System.out.println("\n**Done** Visited " + this.pagesVisited.size() + " web page(s)");
		return pagesVisited;
	}

	/**
	 * Returns the next URL to visit (in the order that they were found). We
	 * also do a check to make sure this method doesn't return a URL that has
	 * already been visited.
	 * 
	 * @return
	 */
	private String nextUrl(String urlValidator) {

		// Checking if the pages to be visited is empty, before proceeding with
		// fetching the next item in list.

		String nextUrl;
		do {

			if (this.pagesToVisit.isEmpty()) {
				return "empty";
			}

			nextUrl = this.pagesToVisit.remove(0);
			//System.out.println(nextUrl);
			// checking to see if the next url is for image or js or css or mp3
			// file. As crawling on those links wont yield any data    FILTERS.matcher(nextUrl).matches() ||
			if ( FILTERS.matcher(nextUrl).matches() || !nextUrl.toLowerCase().contains(urlValidator.toLowerCase())) {
				this.pagesVisited.add(nextUrl);
				//this.pagesToVisit.remove(0);
			}

		} while (this.pagesVisited.contains(nextUrl));
		this.pagesVisited.add(nextUrl);
		return nextUrl;
	}
}
