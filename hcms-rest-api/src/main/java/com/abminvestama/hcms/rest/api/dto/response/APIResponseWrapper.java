package com.abminvestama.hcms.rest.api.dto.response;

import org.springframework.hateoas.ResourceSupport;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class APIResponseWrapper<T> extends ResourceSupport {

	private static final String apiVersion = "1.0.0";
	
	private T data;
	private String message;
	private Page page;
}