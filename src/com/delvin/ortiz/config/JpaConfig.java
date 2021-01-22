package com.delvin.ortiz.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// Having an EntityManagerFacotry & JpaTransactionManager are the minimum required configuration for using Spring Data JPA
@Configuration
@EnableJpaRepositories(basePackages = {"com.delvin.ortiz.candidate"})
@EnableTransactionManagement
public class JpaConfig {

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() { 
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("JobsDB");
		
		return factoryBean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		
		return transactionManager;
	}
	
}
