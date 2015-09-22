package com.prokarma.classified;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prokarma.classified.dao.CategoryDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/application-context.xml")
public class TestMysqlConfiguration {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	@Autowired
	public CategoryDAO categoryDAO;
	
	@Autowired
	public HibernateTemplate hibernateTemplate;
	
	@Test
	public void testDataBaseSession(){
		System.out.println("Session**************"+sessionFactory);
		System.out.println("hibernateTemplate**************"+hibernateTemplate);
		
		System.out.println("categoryDAO**************"+categoryDAO.getCategoryById(1).getDescription());
	}
	

}
