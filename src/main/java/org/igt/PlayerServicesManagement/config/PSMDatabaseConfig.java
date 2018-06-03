package org.igt.PlayerServicesManagement.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.igt.PlayerServicesManagement.dao.PSMUserDao;
import org.igt.PlayerServicesManagement.dao.PSMUserDaoImpl;
import org.igt.PlayerServicesManagement.model.PSMUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("org.igt.PlayerServicesManagement")
@EnableTransactionManagement
public class PSMDatabaseConfig {

		 
		 public DataSource getDataSource() {
		  DriverManagerDataSource drivermanagerdatasource = new DriverManagerDataSource();
		  drivermanagerdatasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		  drivermanagerdatasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		  drivermanagerdatasource.setUsername("Rakesh");
		  drivermanagerdatasource.setPassword("pass"); 
		  System.out.println("Datasource");
		  return drivermanagerdatasource;

		 }


		 private Properties getHibernateProperties()
		 {
		  Properties properties = new Properties();
		  properties.setProperty("hibernate.hbm2ddl.auto","update");
		  properties.put("hibernate.show_sql", "true");
		  properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		  return properties;

		 }
		 @Bean
		  public SessionFactory getSessionFactory()
		     {
		 LocalSessionFactoryBuilder localsessionFactory = new LocalSessionFactoryBuilder(getDataSource());
		 localsessionFactory.addProperties(getHibernateProperties());
		 localsessionFactory.addAnnotatedClass(PSMUser.class);

		 System.out.println("Session created");
		 return localsessionFactory.buildSessionFactory();
		      }

		  @Bean
		    public HibernateTransactionManager getTransaction(SessionFactory sessionFactory)
		    {
		     System.out.println("Transaction");
		      return new HibernateTransactionManager(sessionFactory);
		    }

		  
		     @Autowired
		     @Bean(name="psmuserDao")
		  public PSMUserDao getPSMUserDao(SessionFactory sessionFactory)
		  {
			  return new PSMUserDaoImpl(sessionFactory);
		  }
		}