package com.prokarma.classified.model;

import java.io.Serializable;

public class ItemSubscriptionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int subscriberId;

	private int itemId;

	private int categoryId;

	public ItemSubscriptionPK() {
	}
	public int getSubscriberId() {
		return this.subscriberId;
	}
	public void setSubscriberId(int subscriberId) {
		this.subscriberId = subscriberId;
	}
	public int getItemId() {
		return this.itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ItemSubscriptionPK)) {
			return false;
		}
		ItemSubscriptionPK castOther = (ItemSubscriptionPK)other;
		return 
			(this.subscriberId == castOther.subscriberId)
			&& (this.itemId == castOther.itemId)
			&& (this.categoryId == castOther.categoryId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.subscriberId;
		hash = hash * prime + this.itemId;
		hash = hash * prime + this.categoryId;
		
		return hash;
	}
}