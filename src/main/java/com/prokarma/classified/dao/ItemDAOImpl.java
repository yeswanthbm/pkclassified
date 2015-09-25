package com.prokarma.classified.dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.prokarma.classified.entity.Entity;
import com.prokarma.classified.model.ItemDetail;

@Repository("itemDAO")
public class ItemDAOImpl extends AbstractDAOImpl {

	public <T> Entity<T> findById(Entity<T> entity, String selectQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> int update(Entity<T> entity, String query) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<ItemDetail> getItemDetailsList() {
		final String QUERY = "select * from item_details";
		return getList(new ItemDetail(), QUERY);
	}

	public <T> int addItemDetails(ItemDetail itemDetail) {
		final String SQL = "insert into "
				+ "item_details (name, sub_category_id, price, description, "
				+ "location, active_flag, seller_id, created_ts, updated_ts) "
				+ "values (:name, :sub_category_id, :price, :description, :location, :active_flag, :seller_id, :created_ts, :updated_ts);";
		
		String name = itemDetail.getName();
		int sub_category_id = itemDetail.getSubCategoryId();
		int price = itemDetail.getPrice();
		String description = itemDetail.getDescription();
		String location = itemDetail.getLocation();
		String active_flag = itemDetail.getActiveFlag();
		int seller_id = itemDetail.getSellerId();
		Timestamp created_ts = new Timestamp(new java.util.Date().getTime());
		Timestamp updated_ts = new Timestamp(new java.util.Date().getTime());
		
		Map namedParameters = new HashMap();     
		namedParameters.put("name", name);     
		namedParameters.put("sub_category_id", sub_category_id);  
		namedParameters.put("price", price);  
		namedParameters.put("description", description);
		namedParameters.put("location", location);
		namedParameters.put("active_flag", active_flag);
		namedParameters.put("seller_id", seller_id);
		namedParameters.put("created_ts", created_ts);
		namedParameters.put("updated_ts", updated_ts);
		
		int result = getNamedParameterJdbcTemplate().update(SQL, namedParameters);
		
		return result;
	}

}
