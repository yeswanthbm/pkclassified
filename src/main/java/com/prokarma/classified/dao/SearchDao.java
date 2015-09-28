package com.prokarma.classified.dao;

import java.util.List;

import com.prokarma.classified.model.ItemDetail;

public interface SearchDao {

	public List<ItemDetail> searchItemDetails(String searchString);
}
