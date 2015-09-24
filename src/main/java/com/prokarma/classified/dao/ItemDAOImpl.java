package com.prokarma.classified.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prokarma.classified.entity.Entity;

@Repository("ItemDAO")
public class ItemDAOImpl implements AbstractDAO {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public <T> Entity<T> findById(Entity<T> entity, String selectQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> Entity<T> find(Entity<T> entity, String selectQuery) {
		BeanPropertySqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
				entity);
		return namedParameterJdbcTemplate.queryForObject(selectQuery,
				sqlParameterSource,
				BeanPropertyRowMapper.newInstance(entity.getClass()));
	}

	public <T> List<T> getList(Entity<T> entity, String selectQuery) {
		BeanPropertySqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
				entity);
		return (List<T>) namedParameterJdbcTemplate.query(selectQuery,
				sqlParameterSource,
				BeanPropertyRowMapper.newInstance(entity.getClass()));
	}

	public <T> int update(Entity<T> entity, String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	public <T> Long insert(Entity<T> entity, String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
