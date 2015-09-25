package com.prokarma.classified.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prokarma.classified.dao.ItemDAOImpl;
import com.prokarma.classified.model.ItemDetail;

@Service("itemService")
public class ItemService {

	@Autowired
	private ItemDAOImpl itemDAO;

	public List<ItemDetail> getItemDetails() {
		return itemDAO.getItemDetailsList();
	}
	
	public int addItemDetails(ItemDetail itemDetail) {
		return itemDAO.addItemDetails(itemDetail);
	}
	
}
