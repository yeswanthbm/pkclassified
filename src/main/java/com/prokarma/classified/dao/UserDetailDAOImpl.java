package com.prokarma.classified.dao;

import java.util.HashMap;
import java.util.Map;

import com.prokarma.classified.model.UserDetail;

public class UserDetailDAOImpl extends AbstractDAOImpl implements
		UserDetailDAO {

	public UserDetail getUser(String userId) {
		String query = "SELECT * FROM USER_DETAILS WHERE USER_ID = :USER_ID";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("USER_ID", userId);
		UserDetail userDetail = getNamedParameterJdbcTemplate().queryForObject(
				query, paramMap, UserDetail.class);
		return userDetail;
	}
}
