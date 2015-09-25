package com.prokarma.classified.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.classified.model.ItemDetail;
import com.prokarma.classified.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@RequestMapping(method = RequestMethod.GET)
	public List<ItemDetail> getItemDetails() {
		return itemService.getItemDetails();
	}
	
	@RequestMapping(value="/postAd", method = RequestMethod.POST)
	public int addItem(@RequestBody ItemDetail itemDetail) {
		return itemService.addItemDetails(itemDetail);
	}
}
