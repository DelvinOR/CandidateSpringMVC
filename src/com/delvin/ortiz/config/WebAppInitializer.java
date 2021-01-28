package com.delvin.ortiz.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class WebAppInitializer implements WebApplicationInitializer{
	
	// In order for Spring MVC to work, we need to register a the DispatcherServlet
	// We do this with the help of ApplicationContext
	// DispatcherServlet will handle all request given by the URL mapping "/" and look
	// 	inside of the WebMvcConfig class for configuration
	public void onStartup(ServletContext servletContext) throws ServletException{
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(WebMvcConfig.class);
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
				"SpringDispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}
