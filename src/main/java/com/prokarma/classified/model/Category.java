package com.prokarma.classified.model;

import java.io.Serializable;
import java.util.List;

import com.prokarma.classified.entity.Entity;

//@JsonAutoDetect
public class Category  extends Entity<Category> implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String code;

	private String description;

	private String name;
	
	private String img_loc;
	
	private List<SubCategory> subCategory;
	
	public Category() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg_loc() {
		return img_loc;
	}

	public void setImg_loc(String img_loc) {
		this.img_loc = img_loc;
	}

	public List<SubCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}
	
}