package com.prokarma.classified.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.classified.model.Category;
import com.prokarma.classified.model.SubCategory;
import com.prokarma.classified.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Category> getCategoryList() {
		return categoryService.getCategoryList();
	}
	
	@RequestMapping(value="/subCatByCat/{catId}", method = RequestMethod.GET)
	public List<SubCategory> getSubCategoriesByCatId(@PathVariable int catId) {
		return categoryService.getSubCategoriesByCatId(catId);
	}
	
}
