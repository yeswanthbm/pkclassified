package com.prokarma.classified.dao;

import org.springframework.stereotype.Repository;

import com.prokarma.classified.model.Category;

@Repository
public class CategoryDAOImpl extends GenericDAOHibernateImpl<Category> implements CategoryDAO {

	public Category getCategoryById(int id) {
		if(id != 0){
			return findByID(Category.class, id);
		}
		return null;
	}
	
}
