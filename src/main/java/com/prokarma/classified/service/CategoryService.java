package com.prokarma.classified.service;

import java.util.List;

import com.prokarma.classified.model.Category;
import com.prokarma.classified.model.SubCategory;

public interface CategoryService {

	public List<Category> getCategoryList();

	public List<SubCategory> getSubCategoriesByCatId(int catId);
}
