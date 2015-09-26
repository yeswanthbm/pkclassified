package com.prokarma.classified.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.prokarma.classified.entity.Entity;


/**
 * The persistent class for the sub_category database table.
 * 
 */
@XmlRootElement
@JsonAutoDetect
public class SubCategory extends Entity<SubCategory> implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String code;

	private String description;

	private String name;

	//bi-directional many-to-one association to Category
	private int categoryId;

	public SubCategory() {
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
}