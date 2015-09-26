package com.prokarma.classified.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.prokarma.classified.entity.Entity;


/**
 * The persistent class for the category database table.
 * 
 */
@JsonAutoDetect
public class Category  extends Entity<Category> implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String code;

	private String description;

	private String name;

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

}