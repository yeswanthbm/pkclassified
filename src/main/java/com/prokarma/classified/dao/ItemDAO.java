package com.prokarma.classified.dao;

import java.util.List;

import com.prokarma.classified.model.ItemDetail;

public interface ItemDAO {

	public List<ItemDetail> getItemDetailsList();

	public <T> int addItemDetails(ItemDetail itemDetail);

	public <T> int updateItemDetails(ItemDetail itemDetail);

	public ItemDetail getItemDetailsById(int id);

}
