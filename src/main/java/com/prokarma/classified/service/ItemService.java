package com.prokarma.classified.service;

import java.util.List;

import com.prokarma.classified.model.ItemDetail;

public interface ItemService {

	public List<ItemDetail> getItemDetailList();
	
	public int addItemDetails(ItemDetail itemDetail);
	
	public int updateItemDetails(ItemDetail itemDetail);

	public ItemDetail getItemDetailsById(int id);
}
