package com.prokarma.classified.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String code;

	private String description;

	private String name;

	//bi-directional many-to-one association to ItemSubscription
	@OneToMany(mappedBy="category")
	private List<ItemSubscription> itemSubscriptions;

	//bi-directional many-to-one association to SubCategory
	@OneToMany(mappedBy="category")
	private List<SubCategory> subCategories;

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

	public List<ItemSubscription> getItemSubscriptions() {
		return this.itemSubscriptions;
	}

	public void setItemSubscriptions(List<ItemSubscription> itemSubscriptions) {
		this.itemSubscriptions = itemSubscriptions;
	}

	public ItemSubscription addItemSubscription(ItemSubscription itemSubscription) {
		getItemSubscriptions().add(itemSubscription);
		itemSubscription.setCategory(this);

		return itemSubscription;
	}

	public ItemSubscription removeItemSubscription(ItemSubscription itemSubscription) {
		getItemSubscriptions().remove(itemSubscription);
		itemSubscription.setCategory(null);

		return itemSubscription;
	}

	public List<SubCategory> getSubCategories() {
		return this.subCategories;
	}

	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	public SubCategory addSubCategory(SubCategory subCategory) {
		getSubCategories().add(subCategory);
		subCategory.setCategory(this);

		return subCategory;
	}

	public SubCategory removeSubCategory(SubCategory subCategory) {
		getSubCategories().remove(subCategory);
		subCategory.setCategory(null);

		return subCategory;
	}

}