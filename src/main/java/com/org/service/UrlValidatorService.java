package com.org.service;

import java.util.regex.Pattern;

/** This class is used to check if the given url is valid url string or not. */
public class UrlValidatorService {

	private final static Pattern URL_VALIDATORS = Pattern
			.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");

	/**
	 * 
	 * If the supplied input satisfies the mentioned regular expression, then it
	 * returns true else false
	 * 
	 * @param url
	 *            - URL to be validated
	 */
	public boolean isUrlValid(String url) {

		if (URL_VALIDATORS.matcher(url).matches()) {
			return true;
		} else {
			return false;
		}
	}
}
