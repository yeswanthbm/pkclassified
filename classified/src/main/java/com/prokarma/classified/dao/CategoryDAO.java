package com.prokarma.classified.dao;

import com.prokarma.classified.model.Category;

public interface CategoryDAO extends GenericDAOHibernate<Category>{
	
	public Category getCategoryById(int id);
	
}
