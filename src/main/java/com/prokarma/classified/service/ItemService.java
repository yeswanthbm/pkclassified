package com.prokarma.classified.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prokarma.classified.dao.ItemDAOImpl;
import com.prokarma.classified.model.ItemDetail;

@Service("itemService")
public class ItemService {
	@Autowired
	private ItemDAOImpl ItemDAO;
	
	public List<ItemDetail> getItemDetails(){
		String query="select * from item_details";
	return 	ItemDAO.getList(new ItemDetail(), query);
	}
	

}
