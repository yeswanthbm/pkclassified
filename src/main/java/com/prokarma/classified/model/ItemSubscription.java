package com.prokarma.classified.model;

import java.io.Serializable;


/**
 * The persistent class for the item_subscription database table.
 * 
 */
public class ItemSubscription implements Serializable {
	private static final long serialVersionUID = 1L;

	private ItemSubscriptionPK id;

	private String activeFlag;

	//bi-directional many-to-one association to ItemDetail
	private ItemDetail itemDetail;

	//bi-directional many-to-one association to Category
	private Category category;

	//bi-directional many-to-one association to UserDetail
	private UserDetail userDetail;

	public ItemSubscription() {
	}

	public ItemSubscriptionPK getId() {
		return this.id;
	}

	public void setId(ItemSubscriptionPK id) {
		this.id = id;
	}

	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public ItemDetail getItemDetail() {
		return this.itemDetail;
	}

	public void setItemDetail(ItemDetail itemDetail) {
		this.itemDetail = itemDetail;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}