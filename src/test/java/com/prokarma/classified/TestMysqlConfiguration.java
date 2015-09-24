package com.prokarma.classified;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.prokarma.classified.dao.CategoryDAO;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/application-context.xml")
public class TestMysqlConfiguration {
	
	
	public CategoryDAO categoryDAO;
	
	public HibernateTemplate hibernateTemplate;
	
//	@Test
	public void testDataBaseSession(){
		System.out.println("hibernateTemplate**************"+hibernateTemplate);
		
		System.out.println("categoryDAO**************"+categoryDAO.getCategoryById(1).getDescription());
	}
	

}
