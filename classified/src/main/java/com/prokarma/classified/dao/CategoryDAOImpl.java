package com.prokarma.classified.dao;

import com.prokarma.classified.model.Category;

public class CategoryDAOImpl extends GenericDAOImpl<Category, Integer> implements CategoryDAO {

	public Category getCategoryById(int id) {
		if(id != 0){
			return findByID(Category.class, id);
		}
		return null;
	}

	
}
