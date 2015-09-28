package com.prokarma.classified.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prokarma.classified.dao.SearchDao;
import com.prokarma.classified.model.ItemDetail;

@Service("searchService")
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;
	
	public List<ItemDetail> searchItemDetails(String searchString) {
		return searchDao.searchItemDetails(searchString);
	}

}
