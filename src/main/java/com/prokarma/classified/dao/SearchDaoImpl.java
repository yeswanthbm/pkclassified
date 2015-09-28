package com.prokarma.classified.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.prokarma.classified.model.ItemDetail;

@Repository("searchDao")
public class SearchDaoImpl extends AbstractDAOImpl implements SearchDao {

	public List<ItemDetail> searchItemDetails(String searchString) {
		searchString = "%" + searchString + "%";
		String QUERY = "SELECT name, sub_category_id, price, description, "
				+ " location, active_flag, seller_id, created_ts, updated_ts FROM ITEM_DETAILS "
				+ " WHERE NAME LIKE :SEARCHPARAM OR DESCRIPTION LIKE :SEARCHPARAM "
				+ " OR SUB_CATEGORY_ID IN (SELECT ID FROM SUB_CATEGORY WHERE NAME LIKE :SEARCHPARAM "
				+ " OR DESCRIPTION LIKE :SEARCHPARAM OR CATEGORY_ID IN (SELECT ID FROM CATEGORY WHERE NAME LIKE :SEARCHPARAM "
				+ " OR DESCRIPTION LIKE :SEARCHPARAM ))";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<ItemDetail> itemDetails = getNamedParameterJdbcTemplate().query(QUERY,
				paramMap,
				BeanPropertyRowMapper.newInstance(ItemDetail.class));
		return itemDetails;
	}
}
