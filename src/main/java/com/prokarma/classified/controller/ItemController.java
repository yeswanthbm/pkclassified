package com.prokarma.classified.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<ItemDetail> getItemDetailList() {
		return itemService.getItemDetailList();
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public ItemDetail getItemDetailsById(@PathVariable int id) {
		return itemService.getItemDetailsById(id);
	}
	
	@RequestMapping(value="/postAd", method = RequestMethod.POST)
	public int addItem(@RequestBody ItemDetail itemDetail) {
		return itemService.addItemDetails(itemDetail);
	}
	
	@RequestMapping(value="/updateAd", method = RequestMethod.POST)
	public int updateItemDetails(@RequestBody ItemDetail itemDetail) {
		return itemService.updateItemDetails(itemDetail);
	}
}
