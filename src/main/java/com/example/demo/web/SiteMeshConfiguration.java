package com.example.demo.web;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class SiteMeshConfiguration {

	@Bean
	CustomSiteMeshFilter customSiteMeshFilter() {
		return new CustomSiteMeshFilter();
	}

	@Bean
	FilterRegistrationBean<CustomSiteMeshFilter> siteMeshFilter(CustomSiteMeshFilter customSiteMeshFilter) {
		FilterRegistrationBean<CustomSiteMeshFilter> registration = new FilterRegistrationBean<>();
		registration.setFilter(customSiteMeshFilter);
		registration.setName("siteMeshFilter");
		registration.addUrlPatterns("/*");
		registration.setOrder(Ordered.LOWEST_PRECEDENCE);
		return registration;
	}
}
