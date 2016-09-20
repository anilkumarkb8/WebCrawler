package com.org.service;

import java.util.regex.Pattern;

public class UrlValidatorService {

	private final static Pattern URL_VALIDATORS = Pattern
			.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");

	public boolean isUrlValid(String url) {

		if (URL_VALIDATORS.matcher(url).matches()) {
			return true;
		} else {
			return false;
		}
	}
}
