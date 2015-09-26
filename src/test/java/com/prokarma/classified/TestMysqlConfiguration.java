package com.prokarma.classified;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.prokarma.classified.dao.CategoryDAOImpl;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/application-context.xml")
public class TestMysqlConfiguration {
	
	
	public CategoryDAOImpl categoryDAOImpl;
	
	public HibernateTemplate hibernateTemplate;
	
//	@Test
	public void testDataBaseSession(){
		System.out.println("hibernateTemplate**************"+hibernateTemplate);
		
		System.out.println("categoryDAO**************"+categoryDAOImpl);
	}
	

}
