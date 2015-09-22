package com.prokarma.classified.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;

/**
 * Provides the basic Hibernate operations 
 *
 * @param <T>
 */
public interface GenericDAOHibernate<T> extends Serializable {

	 void delete(T entity);

     void deleteAll(Class<T> entityClass);

     void deleteByID(Class<T> entityClass, Serializable id);
    
     void update(T entity);
    
     void merge(T entity);
    
     Serializable save(T entity);
    
     void saveOrUpdateAll(Collection<T> entity);
    
     List<T> findAll(Class<T> entityClass);

     T findByID(Class<T> entityClass, Serializable id);
    
     T findById(long id, LockMode lockMode);
    
     List<T> findByCriteria(DetachedCriteria dc);
    
     List<T> findByCriteria(DetachedCriteria dc, int from, int size);
}
