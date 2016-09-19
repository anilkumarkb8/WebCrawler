package com.org.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.service.CrawlerService;

@Controller
public class CrawlerController {
	
	@RequestMapping("/test")
	public ModelAndView testMessage(
			@RequestParam(value = "name", required = false) String name) {
		// Name of your jsp file as parameter
		CrawlerService crawl = new CrawlerService();
		
		
		Set<String> pagesVisited = new HashSet<String>();
		
		pagesVisited = crawl.search("http://arstechnica.com/", "http://arstechnica.com/");
		
		System.out.println(pagesVisited);
		
		ModelAndView view = new ModelAndView("test");
		view.addObject("name", name);
		return view;
	}

}
