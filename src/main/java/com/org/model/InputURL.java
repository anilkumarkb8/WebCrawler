package com.org.model;

/**
 * This class is created to hold one String data in object. It is designed in
 * order to map the form data received from frontend text field where user
 * enters the URL
 */
public class InputURL {

	private String url;

	public String getInputUrl() {
		return url;
	}

	public void setInputUrl(String inputUrl) {
		this.url = inputUrl;
	}

	@Override
	public String toString() {
		return "InputURL [inputUrl=" + url + "]";
	}

}
