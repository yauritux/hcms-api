package com.abminvestama.hcms.rest.api.dto.response;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * All responses from the REST APIs should be wrapped within this particular class.
 *
 */
public class APIResponseWrapper<T> extends ResourceSupport {

	private static final String apiVersion = "1.0.0";
	
	private T data;
	private String message;
	private Page page;
	
	public APIResponseWrapper() {}
	
	public APIResponseWrapper(T data) {
		this.data = data;
	}
	
	public APIResponseWrapper(T data, Page page) {
		this.data = data;
		this.page = page;
	}
	
	public APIResponseWrapper(String message) {
		this.message = message;
	}
	
	@JsonProperty("api_version")
	public final String getApiVersion() {
		return apiVersion;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Page getPage() {
		return page;
	}
	
	public void setPage(Page page) {
		this.page = page;
	}
}