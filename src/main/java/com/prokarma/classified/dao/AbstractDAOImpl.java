package com.prokarma.classified.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.prokarma.classified.entity.Entity;

/**
 * The Class BaseDaoImpl.
 */
@Repository("baseDao")
public class AbstractDAOImpl implements AbstractDAO
{


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate()
    {

        return namedParameterJdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    
    @Override
    public <T> Entity<T> findById(final Entity<T> entity, final String selectQuery)
    {

        return find(entity, selectQuery);
    }

    /**
     * Find.
     *
     * @param <T>
     *            the generic type
     * @param entity
     *            the entity
     * @param selectQuery
     *            the select query
     * @return the object
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> Entity<T> find(final Entity<T> entity, final String selectQuery)
    {

        BeanPropertySqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(entity);
        return namedParameterJdbcTemplate.queryForObject(selectQuery, sqlParameterSource,
            BeanPropertyRowMapper.newInstance(entity.getClass()));
    }

    /**
     * Gets the list.
     *
     * @param <T>
     *            the generic type
     * @param entity
     *            the entity
     * @param selectQuery
     *            the select query
     * @return the list
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> getList(final Entity<T> entity, final String selectQuery)
    {

        BeanPropertySqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(entity);
        return (List<T>) namedParameterJdbcTemplate.query(selectQuery, sqlParameterSource,
            BeanPropertyRowMapper.newInstance(entity.getClass()));
    }

    /**
     * Update.
     *
     * @param <T>
     *            the generic type
     * @param entity
     *            the entity
     * @param query
     *            the query
     * @return the int
     */
    @Override
    public <T> int update(final Entity<T> entity, final String query)
    {
        BeanPropertySqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(entity);
        return namedParameterJdbcTemplate.update(query, sqlParameterSource);
    }

    /**
     * Insert.
     *
     * @param <T>
     *            the generic type
     * @param entity
     *            the entity
     * @param query
     *            the query
     * @return the long
     */
    @Override
    public <T> Long insert(final Entity<T> entity, final String query)
    {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        BeanPropertySqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(entity);

        namedParameterJdbcTemplate.update(query, sqlParameterSource, keyHolder);

        Long generatedId = Long.valueOf(keyHolder.getKey().longValue());

        return generatedId;
    }


}
