package com.prokarma.classified.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prokarma.classified.dao.ItemDAO;
import com.prokarma.classified.model.ItemDetail;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO itemDAO;

	public List<ItemDetail> getItemDetailList() {
		return itemDAO.getItemDetailsList();
	}
	
	public int addItemDetails(ItemDetail itemDetail) {
		return itemDAO.addItemDetails(itemDetail);
	}
	
	public int updateItemDetails(ItemDetail itemDetail) {
		return itemDAO.updateItemDetails(itemDetail);
	}

	public ItemDetail getItemDetailsById(int id) {
		return itemDAO.getItemDetailsById(id);
	}
	
}
