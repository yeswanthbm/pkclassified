package com.prokarma.classified.model;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the sub_category database table.
 * 
 */
public class SubCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String code;

	private String description;

	private String name;

	//bi-directional many-to-one association to ItemDetail
	private List<ItemDetail> itemDetails;

	//bi-directional many-to-one association to Category
	private Category category;

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

	public List<ItemDetail> getItemDetails() {
		return this.itemDetails;
	}

	public void setItemDetails(List<ItemDetail> itemDetails) {
		this.itemDetails = itemDetails;
	}

	public ItemDetail addItemDetail(ItemDetail itemDetail) {
		getItemDetails().add(itemDetail);
		itemDetail.setSubCategory(this);

		return itemDetail;
	}

	public ItemDetail removeItemDetail(ItemDetail itemDetail) {
		getItemDetails().remove(itemDetail);
		itemDetail.setSubCategory(null);

		return itemDetail;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}