package com.abminvestama.hcms.core.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Configuration
public class BaseCoreServiceConfig {

	@Bean
	public BaseCoreServiceTester baseCoreServiceTester() {
		return new BaseCoreServiceTester();
	}
}