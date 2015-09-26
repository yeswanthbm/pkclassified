package com.prokarma.classified.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.classified.dao.CategoryDAOImpl;
import com.prokarma.classified.model.Category;
import com.prokarma.classified.model.SubCategory;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryDAOImpl categoryDAO;

	@RequestMapping(method = RequestMethod.GET)
	public List<Category> getCategoryList() {
		return categoryDAO.getCategoryList();
	}
	
	@RequestMapping(value="/subCatByCat/{catId}", method = RequestMethod.GET)
	public List<SubCategory> getSubCategoriesByCatId(@PathVariable int catId) {
		return categoryDAO.getSubCategoriesByCatId(catId);
	}
	
}
