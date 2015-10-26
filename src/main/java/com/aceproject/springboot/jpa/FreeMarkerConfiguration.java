package com.aceproject.springboot.jpa;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class FreeMarkerConfiguration {
	private static final Log logger = LogFactory.getLog(FreeMarkerConfiguration.class);

	@Resource
	private FreeMarkerProperties properties;

	private void applyProperties(FreeMarkerConfigurationFactory factory) {
		factory.setTemplateLoaderPath(properties.getTemplateLoaderPath());
		factory.setPreferFileSystemAccess(Boolean.parseBoolean(properties
				.getPreferFileSystemAccess()));
		factory.setDefaultEncoding(properties.getDefaultEncoding());
		factory.setFreemarkerVariables(properties.getFreemarkerVariables());

		if (logger.isDebugEnabled())
			logger.debug("");
	}

	@Bean
	@ConditionalOnMissingBean(FreeMarkerConfig.class)
	public FreeMarkerConfigurer freeMarkerConfigurer() {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		applyProperties(configurer);

		if (logger.isDebugEnabled())
			logger.debug("");

		return configurer;
	}

	@Bean
	public freemarker.template.Configuration freeMarkerConfiguration(
			FreeMarkerConfig configurer) {
		if (logger.isDebugEnabled())
			logger.debug("");

		return configurer.getConfiguration();
	}

	@Bean
	@ConditionalOnMissingBean(name = "freeMarkerViewResolver")
	@ConditionalOnProperty(name = "spring.freemarker.enabled", matchIfMissing = true)
	public FreeMarkerViewResolver freeMarkerViewResolver() {
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		properties.applyToViewResolver(resolver);

		if (logger.isDebugEnabled())
			logger.debug("");

		return resolver;
	}
}