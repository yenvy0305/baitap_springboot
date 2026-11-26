package com.example.demo.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class JspViewConfiguration {

	@Bean
	InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		// Needed when SiteMesh's servlet filter decorates JSP views on Tomcat 11.
		resolver.setAlwaysInclude(true);
		return resolver;
	}
}
