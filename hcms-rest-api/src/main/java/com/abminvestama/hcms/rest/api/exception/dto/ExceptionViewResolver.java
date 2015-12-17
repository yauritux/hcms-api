package com.abminvestama.hcms.rest.api.exception.dto;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class ExceptionViewResolver extends MappingJackson2JsonView {

	private ExceptionResponseWrapper exceptionResponse;
	
	public ExceptionViewResolver(ExceptionResponseWrapper exceptionResponse) {
		this.exceptionResponse = exceptionResponse;
	}
	
	public ExceptionResponseWrapper getExceptionResponse() {
		return exceptionResponse;
	}
}