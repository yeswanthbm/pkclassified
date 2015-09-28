package com.prokarma.classified.dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.prokarma.classified.entity.Entity;
import com.prokarma.classified.model.ItemDetail;

@Repository("itemDAO")
public class ItemDAOImpl extends AbstractDAOImpl implements ItemDAO {

	public <T> int update(Entity<T> entity, String query) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<ItemDetail> getItemDetailsList() {
		final String QUERY = "select * from item_details";
		return getList(new ItemDetail(), QUERY);
	}

	public <T> int addItemDetails(ItemDetail itemDetail) {
		int result = 0;
		if(itemDetail != null){
			final String SQL = "insert into "
					+ "item_details (name, sub_category_id, price, description, "
					+ "location, active_flag, seller_id, created_ts, updated_ts) "
					+ "values (:name, :sub_category_id, :price, :description, :location, :active_flag, :seller_id, :created_ts, :updated_ts);";
			
			
			final String name = itemDetail.getName();
			final int sub_category_id = itemDetail.getSubCategoryId();
			final int price = itemDetail.getPrice();
			final String description = itemDetail.getDescription();
			final String location = itemDetail.getLocation();
			final String active_flag = "T";
			final int seller_id = itemDetail.getSellerId();
			final Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
			final Timestamp created_ts = timestamp;
			final Timestamp updated_ts = timestamp;
			
			Map<String, Object> namedParameters = new HashMap<String, Object>();     
			namedParameters.put("name", name);     
			namedParameters.put("sub_category_id", sub_category_id);  
			namedParameters.put("price", price);  
			namedParameters.put("description", description);
			namedParameters.put("location", location);
			namedParameters.put("active_flag", active_flag);
			namedParameters.put("seller_id", seller_id);
			namedParameters.put("created_ts", created_ts);
			namedParameters.put("updated_ts", updated_ts);
			
			result = getNamedParameterJdbcTemplate().update(SQL, namedParameters);
		}
		return result;
	}
	
	public <T> int updateItemDetails(ItemDetail itemDetail) {
		int result = 0;
		if(itemDetail != null){
			final String SQL = "update item_details "
					+ "set name=:name, price=:price, description=:description, location=:location, updated_ts=:updated_ts "
					+ "where id=:id";
			
			final int id = itemDetail.getId();
			final String name = itemDetail.getName();
			final int price = itemDetail.getPrice();
			final String description = itemDetail.getDescription();
			final String location = itemDetail.getLocation();
			final Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
			final Timestamp updated_ts = timestamp;
			
			Map<String, Object> namedParameters = new HashMap<String, Object>();   
			namedParameters.put("id", id);
			namedParameters.put("name", name);     
			namedParameters.put("price", price);  
			namedParameters.put("description", description);
			namedParameters.put("location", location);
			namedParameters.put("updated_ts", updated_ts);
			
			result = getNamedParameterJdbcTemplate().update(SQL, namedParameters);
		}
		return result;
	}

	public ItemDetail getItemDetailsById(int id) {
		final String QUERY = "select * from item_details where id=" + id;
		return (ItemDetail) findById(new ItemDetail(), QUERY);
	}

}
