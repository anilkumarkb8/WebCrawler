package com.org.service;

import java.util.*;
import java.util.regex.Pattern;

/**
 * This method hold the business logic for crawling through the URL supplied.
 * 
 */
public class CrawlerService {

	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpe?g|png|mp3|mp3|zip|gz))$");
	private Set<String> pagesVisited = new HashSet<String>();
	private List<String> pagesToVisit = new LinkedList<String>();

	/**
	 * This method crawls through the url supplied to it.
	 * 
	 * It performs validations such as:
	 * 
	 * - Check if the URL belongs to same domain or not. If yes, then crawl
	 * deep. Else, move to next URL in list.
	 * 
	 * - Checks if the URL is Browsable link. If its not then it moves to next
	 * link without considering the current one for further crawling
	 * 
	 * @param url
	 *            - The starting point of the crawler
	 * 
	 * @return pagesVisited - Returns all the links which have been fetched from
	 *         supplied input in its domain by deep crawling
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
			} else {
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
	 * It also performs validations such as:
	 * 
	 * - Check if the URL belongs to same domain or not. If yes, then crawl
	 * deep. Else, move to next URL in list.
	 * 
	 * - Checks if the URL is Browsable link. If its not then it moves to next
	 * link without considering the current one for further crawling
	 * 
	 * @param url:
	 *            - URL on which the above mentioned checks are to be done
	 * 
	 * @return 
	 *            - Next URL to be Browsed
	 */
	private String nextUrl(String url) {

		/*
		 * Checking if the pages to be visited is empty, before proceeding with
		 * fetching the next item in list.
		 */
		String nextUrl;
		do {

			if (this.pagesToVisit.isEmpty()) {
				return "empty";
			}

			nextUrl = this.pagesToVisit.remove(0);
			System.out.println(nextUrl);
			/*
			 * checking to see if the next url is for image or js or css or mp3
			 * file. As crawling on those links wont yield any data And also
			 * checking if the link belongs to the domain entered by user or not
			 */
			if (FILTERS.matcher(nextUrl).matches() || !nextUrl.toLowerCase().contains(url.toLowerCase())) {
				this.pagesVisited.add(nextUrl);
				// this.pagesToVisit.remove(0);
			}

		} while (this.pagesVisited.contains(nextUrl));
		this.pagesVisited.add(nextUrl);
		return nextUrl;
	}
}
