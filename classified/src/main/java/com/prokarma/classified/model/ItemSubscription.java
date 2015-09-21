package com.prokarma.classified.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item_subscription database table.
 * 
 */
@Entity
@Table(name="item_subscription")
@NamedQuery(name="ItemSubscription.findAll", query="SELECT i FROM ItemSubscription i")
public class ItemSubscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemSubscriptionPK id;

	@Column(name="ACTIVE_FLAG")
	private String activeFlag;

	//bi-directional many-to-one association to ItemDetail
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private ItemDetail itemDetail;

	//bi-directional many-to-one association to Category
	@ManyToOne
	private Category category;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="SUBSCRIBER_ID")
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