package com.example.demo.web;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class CustomSiteMeshFilter extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/*", "/WEB-INF/views/web.jsp")
				.addDecoratorPath("/admin/*", "/WEB-INF/views/admin.jsp")
				.addExcludedPath("/login*")
				.addExcludedPath("/register*")
				.addExcludedPath("/logout")
				.addExcludedPath("/static/*")
				.addExcludedPath("/api/*");
	}
}
