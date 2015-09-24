package com.prokarma.classified.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.prokarma.classified.entity.Entity;


public interface AbstractDAO
{

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate();

    public <T> Entity<T> findById(final Entity<T> entity, final String selectQuery);

    public <T> Entity<T> find(final Entity<T> entity, final String selectQuery);

    public <T> List<T> getList(final Entity<T> entity, final String selectQuery);

    public <T> int update(final Entity<T> entity, final String query);

    public <T> Long insert(final Entity<T> entity, final String query);


}
