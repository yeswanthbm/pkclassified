package com.prokarma.classified.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.prokarma.classified.entity.Entity;


/**
 * The persistent class for the item_details database table.
 * 
 */
public class ItemDetail extends Entity<ItemDetail> implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String activeFlag;

	private Timestamp createdTs;

	private String description;

	private String location;

	private String name;

	private int price;

	private int sellerId;

	private Timestamp updatedTs;

	//bi-directional many-to-one association to SubCategory
	private SubCategory subCategory;

	//bi-directional many-to-one association to ItemSubscription
	private List<ItemSubscription> itemSubscriptions;

	public ItemDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Timestamp getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public Timestamp getUpdatedTs() {
		return this.updatedTs;
	}

	public void setUpdatedTs(Timestamp updatedTs) {
		this.updatedTs = updatedTs;
	}

	public SubCategory getSubCategory() {
		return this.subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public List<ItemSubscription> getItemSubscriptions() {
		return this.itemSubscriptions;
	}

	public void setItemSubscriptions(List<ItemSubscription> itemSubscriptions) {
		this.itemSubscriptions = itemSubscriptions;
	}

	public ItemSubscription addItemSubscription(ItemSubscription itemSubscription) {
		getItemSubscriptions().add(itemSubscription);
		itemSubscription.setItemDetail(this);

		return itemSubscription;
	}

	public ItemSubscription removeItemSubscription(ItemSubscription itemSubscription) {
		getItemSubscriptions().remove(itemSubscription);
		itemSubscription.setItemDetail(null);

		return itemSubscription;
	}

}