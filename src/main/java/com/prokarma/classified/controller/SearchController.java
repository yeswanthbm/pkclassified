package com.prokarma.classified.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.classified.model.ItemDetail;
import com.prokarma.classified.service.SearchService;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchService searchService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<ItemDetail> searchtemDetail(
			@RequestParam("searchString") String searchString) {
		return searchService.searchItemDetails(searchString);
	}
}
