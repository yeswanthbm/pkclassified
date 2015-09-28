package com.prokarma.classified.service;

import java.util.List;

import com.prokarma.classified.model.ItemDetail;

public interface SearchService {

	public List<ItemDetail> searchItemDetails(String searchString);
}
