package com.prokarma.classified.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prokarma.classified.dao.CategoryDAO;
import com.prokarma.classified.model.Category;
import com.prokarma.classified.model.SubCategory;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	public List<Category> getCategoryList() {
		return categoryDAO.getCategoryList();
	}

	public List<SubCategory> getSubCategoriesByCatId(int catId) {
		return categoryDAO.getSubCategoriesByCatId(catId);
	}

	
}
