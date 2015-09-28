package com.prokarma.classified.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.prokarma.classified.dao.UserDetailDAO;
import com.prokarma.classified.model.UserDetail;

public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	private UserDetailDAO userDetailDAO;

	public UserDetail getUser(String userId) {
		return userDetailDAO.getUser(userId);
	}

}
