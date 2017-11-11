package com.library.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages={"com.library"})
@EnableTransactionManagement
public class JPAConfig {

	 @Bean
	 public DataSource dataSource(){
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11204326");
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUsername("sql11204326");
		basicDataSource.setPassword("iA42d8kwjm");
//		basicDataSource.setMaxActive(5);
//		basicDataSource.setMinIdle(3);
		return basicDataSource;
	 }
	 
//	 @Bean
//	 public EntityManagerFactory entityManagerFactory(){
//		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
//		bean.setDataSource(dataSource());
//		bean.setPackagesToScan("com.library");
//		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//		jpaVendorAdapter.setDatabase(Database.SQL_SERVER);
//		//jpaVendorAdapter.setGenerateDdl(true);
//		//jpaVendorAdapter.setShowSql(true);
//		bean.setJpaDialect(new HibernateJpaDialect());
//		bean.setJpaProperties(hibernateProperties());
//		bean.setJpaVendorAdapter(jpaVendorAdapter);
//		bean.afterPropertiesSet();
//		return bean.getObject();
//	 }
	 
	  @Bean
	  public EntityManagerFactory entityManagerFactory() {

	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("com.library");
	    factory.setDataSource(dataSource());
	    factory.afterPropertiesSet();

	    return factory.getObject();
	  }
	 
	 
	 public Properties hibernateProperties(){
		 Properties properties = new Properties();
		 properties.put("hibernate.hbm2ddl.auto", "create-drop");
		 properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//		 properties.put("hibernate.show_sql", "true");
		 properties.put("hibernate.format_sql", "true");
		 properties.put("hibernate.ejb.naming_strategy", "hibernate.ejb.naming_strategy");
		 return  properties;
	 }
	 
	@Bean
	public JpaTransactionManager transactionManager(){
	    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
	    jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
	    return jpaTransactionManager;
	}
}
