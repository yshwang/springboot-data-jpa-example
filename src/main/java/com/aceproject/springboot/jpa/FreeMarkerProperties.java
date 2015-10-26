package com.aceproject.springboot.jpa;

import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.template.AbstractTemplateViewResolverProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.google.common.collect.Maps;

@Data
@EqualsAndHashCode(callSuper = true)
@ConfigurationProperties(prefix = "freemarker")
public class FreeMarkerProperties extends AbstractTemplateViewResolverProperties {
	private static final Log logger = LogFactory.getLog(FreeMarkerProperties.class);
	
	
	public static final String DEFAULT_PREFIX = "/";
	public static final String DEFAULT_SUFFIX = ".ftl";
	
	public FreeMarkerProperties() {
		super(DEFAULT_PREFIX, DEFAULT_SUFFIX);
	}
	
	protected FreeMarkerProperties(String defaultPrefix, String defaultSuffix) {
		super(defaultPrefix, defaultSuffix);
	}

	private String templateLoaderPath;
	private String preferFileSystemAccess; 
	private String defaultEncoding;

	private String testUrl;

	public Map<String, Object> getFreemarkerVariables() {
		Map<String, Object> variables = Maps.newHashMap();
		variables.put("testUrl", testUrl);
		
		if (logger.isDebugEnabled())
			logger.debug("testUrl : " + testUrl);
		
		return variables;
	}

}
