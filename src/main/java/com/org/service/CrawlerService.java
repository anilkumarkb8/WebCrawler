package com.org.service;

import java.util.*;
import java.util.regex.Pattern;

public class CrawlerService {

	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpe?g" + "|png|mp3|mp3|zip|gz))$");
	private Set<String> pagesVisited = new HashSet<String>();
	private List<String> pagesToVisit = new LinkedList<String>();

	/**
	 * Our main launching point for the Spider's functionality. Internally it
	 * creates spider legs that make an HTTP request and parse the response (the
	 * web page).
	 * 
	 * @param url
	 *            - The starting point of the spider
	 * @param searchWord
	 *            - The word or string that you are searching for
	 */
	public Set<String> search(String url, String urlValidator) {
		
		do{
			String currentUrl;
			CustomCrawlerImpl leg = new CustomCrawlerImpl();
			if (this.pagesToVisit.isEmpty()) {
				currentUrl = url;
				this.pagesVisited.add(url);
			} else {
				currentUrl = this.nextUrl();
				if(FILTERS.matcher(currentUrl).matches()){
					currentUrl = this.nextUrl();
				}
			}
			
			boolean status = leg.crawl(currentUrl);
			if (status) {
				this.pagesToVisit.addAll(leg.getLinks());
			}
		} while(this.pagesVisited.size() > 0);
			
		
		
		
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
	private String nextUrl() {
		String nextUrl;
		do {
			nextUrl = this.pagesToVisit.remove(0);
		} while (this.pagesVisited.contains(nextUrl));
		this.pagesVisited.add(nextUrl);
		return nextUrl;
	}
}
