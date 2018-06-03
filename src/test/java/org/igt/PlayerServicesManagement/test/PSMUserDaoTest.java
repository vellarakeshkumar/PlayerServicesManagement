package org.igt.PlayerServicesManagement.test;


import static org.junit.Assert.*;

import org.igt.PlayerServicesManagement.config.PSMDatabaseConfig;
import org.igt.PlayerServicesManagement.dao.PSMUserDao;
import org.igt.PlayerServicesManagement.model.PSMUser;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class PSMUserDaoTest {
	
	static PSMUserDao psmuserDao;
	
	@BeforeClass
	public static void initialize()
	{
		 AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.register(PSMDatabaseConfig.class);
		annotationConfigAppContext.scan("org.igt.PlayerServiceManagement");
		annotationConfigAppContext.refresh();
		psmuserDao=(PSMUserDao)annotationConfigAppContext.getBean("psmuserDao");
	}
	
	
@Test
public void createUserTest()
	{
		
	PSMUser psmUser=new PSMUser();
	psmUser.setFirstName("Siva");
	psmUser.setLastName("Vella");
	psmUser.setPassword("password");
	psmUser.setEmail("siva@psm.com");
	assertTrue("PSM User have been created",psmuserDao.createUser(psmUser));
	}
	
	
}


