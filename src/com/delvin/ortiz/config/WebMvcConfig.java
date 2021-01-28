package com.delvin.ortiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// @Configuration tag tells Spring that this is a configuration class and 
// @ComponentScan tells Spring to scan for configuration classes in package given
@Configuration
@EnableWebMvc
@ComponentScan("com.delvin.ortiz ")
public class WebMvcConfig {
	
	// @Bean helps us define a view resolver that will specify the prefix and suffix of
	// 	for the view files and we create the view files in the "/Web-INF/views/ directory
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
