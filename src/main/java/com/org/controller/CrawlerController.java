package com.org.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.org.model.InputURL;
import com.org.service.CrawlerService;
import com.org.service.UrlValidatorService;

@Controller
public class CrawlerController {

	@RequestMapping(value = "/crawler", method = RequestMethod.POST)
	public ModelAndView testMessage(@ModelAttribute("iURL") InputURL inputURL) {
		ModelAndView view = new ModelAndView("test");
		UrlValidatorService urlValidatorService = new UrlValidatorService();
		CrawlerService crawl = new CrawlerService();

		if (urlValidatorService.isUrlValid(inputURL.getInputUrl())) {
			Set<String> pagesVisited = new HashSet<String>();

			// pagesVisited = crawl.search("http://wiprodigital.com/");
			pagesVisited = crawl.search(inputURL.getInputUrl());

			System.out.println(pagesVisited.toString());
			view.addObject("name", "Success");
		} else {
			view.addObject("name", "Failure");
		}

		return view;
	}

	@RequestMapping(value = "/crawler", method = RequestMethod.GET)
	public ModelAndView getCrawler() {

		return new ModelAndView("crawlInput", "iURL", new InputURL());
	}

}
