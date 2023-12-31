package com.ccsw.tutorialloan.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ccsw
 * 
 */
@Configuration
public class BeanDozerConfig {

	@Bean
	public DozerBeanMapper getDozerBeanMapper() {

		return new DozerBeanMapper();
	}

}
