package com.prokarma.classified.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the item_details database table.
 * 
 */
@Entity
@Table(name="item_details")
@NamedQuery(name="ItemDetail.findAll", query="SELECT i FROM ItemDetail i")
public class ItemDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="ACTIVE_FLAG")
	private String activeFlag;

	@Column(name="CREATED_TS")
	private Timestamp createdTs;

	private String description;

	private String location;

	private String name;

	private int price;

	@Column(name="SELLER_ID")
	private int sellerId;

	@Column(name="UPDATED_TS")
	private Timestamp updatedTs;

	//bi-directional many-to-one association to SubCategory
	@ManyToOne
	@JoinColumn(name="SUB_CATEGORY_ID")
	private SubCategory subCategory;

	//bi-directional many-to-one association to ItemSubscription
	@OneToMany(mappedBy="itemDetail")
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