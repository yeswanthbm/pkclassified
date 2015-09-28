package com.prokarma.classified.model;

import java.io.Serializable;
import java.util.List;

public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String address;

	private String alternateNo;

	private String contactNo;

	private String emailId;

	private String name;

	private String password;

	private String userId;

	//bi-directional many-to-one association to ItemSubscription
	private List<ItemSubscription> itemSubscriptions;

	public UserDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAlternateNo() {
		return this.alternateNo;
	}

	public void setAlternateNo(String alternateNo) {
		this.alternateNo = alternateNo;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<ItemSubscription> getItemSubscriptions() {
		return this.itemSubscriptions;
	}

	public void setItemSubscriptions(List<ItemSubscription> itemSubscriptions) {
		this.itemSubscriptions = itemSubscriptions;
	}

	public ItemSubscription addItemSubscription(ItemSubscription itemSubscription) {
		getItemSubscriptions().add(itemSubscription);
		itemSubscription.setUserDetail(this);

		return itemSubscription;
	}

	public ItemSubscription removeItemSubscription(ItemSubscription itemSubscription) {
		getItemSubscriptions().remove(itemSubscription);
		itemSubscription.setUserDetail(null);

		return itemSubscription;
	}

}