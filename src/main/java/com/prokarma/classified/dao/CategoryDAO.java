package com.prokarma.classified.dao;

import java.util.List;

import com.prokarma.classified.model.Category;
import com.prokarma.classified.model.SubCategory;

public interface CategoryDAO {

	public List<Category> getCategoryList();

	public List<SubCategory> getSubCategoriesByCatId(int catId);

}
