package com.prokarma.classified.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.hibernate4.HibernateQueryException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDAOHibernateImpl<T> implements GenericDAOHibernate<T> {

	private static final  long serialVersionUID = 1L;
	
	@Autowired
	public transient HibernateTemplate hibernateTemplate;
	
	private Class<T> persistentClass;

	/**
	 * @return the persistentClass
	 */
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	/**
	 * @param persistentClass the persistentClass to set
	 */
	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public void delete(T entity) {
        hibernateTemplate.delete(entity);
    }

    public void deleteAll(Class<T> entityClass) {
    	hibernateTemplate.deleteAll(findAll(entityClass));
    }

    public void deleteByID(Class<T> entityClass, Serializable id) {
        delete(findByID(entityClass, id));
    }
    
    public List<T> findAll(Class<T> entityClass) {
    	DetachedCriteria criteria = getDetachedCriteria(entityClass);
    	List<T> list;
    	try {
    		criteria.add(Property.forName("deletedFlag").eq(false));
    		list = findByCriteria(criteria); 
		} catch (HibernateQueryException e) {
			return hibernateTemplate.loadAll(entityClass);
		}
		return list;
    }

    public T findByID(Class<T> entityClass, Serializable id) {
        return hibernateTemplate.get(entityClass, id);
    }

    public Serializable save(T entity) {
        return hibernateTemplate.save(entity);
    }

    public void update(T entity) {
        hibernateTemplate.update(entity);
    }
    
    public void merge(T entity) {
        hibernateTemplate.merge(entity);
    }
    
    public void saveOrUpdateAll(Collection<T> entity){
        hibernateTemplate.saveOrUpdate(entity);
    }

	/**
	 * @return the hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * @param hibernateTemplate the hibernateTemplate to set
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List<T> findByCriteria(DetachedCriteria dc) {
		return (List<T>) hibernateTemplate.findByCriteria(dc, -1, -1);
	}

	public List<T> findByCriteria(DetachedCriteria criteria, int from, int size) {
		return (List<T>) hibernateTemplate.findByCriteria(criteria, from, size);
    }

	public T findById(long id, LockMode lockMode) {
		return (T)hibernateTemplate.get(getPersistentClass(), id, lockMode);

	}
	
	protected DetachedCriteria getDetachedCriteria(Class<T> clazz) {
    	return DetachedCriteria.forClass(clazz);
    }
	
}