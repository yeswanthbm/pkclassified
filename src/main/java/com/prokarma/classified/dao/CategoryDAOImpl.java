package com.prokarma.classified.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.prokarma.classified.entity.Entity;
import com.prokarma.classified.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl extends AbstractDAOImpl {

	public <T> Entity<T> findById(Entity<T> entity, String selectQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> int update(Entity<T> entity, String query) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<Category> getCategoryList() {
		final String QUERY = "select * from category";
		return getList(new Category(), QUERY);
	}

	
}
