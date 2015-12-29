package com.abminvestama.hcms.rest.api.dto.response;

import java.util.Calendar;

import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.common.util.CommonDateFunction;
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
	private String serverDate;
	
	public APIResponseWrapper() {
		Calendar cal = Calendar.getInstance();
		serverDate = new StringBuilder(
				CommonDateFunction.getMonthFullName(cal.get(Calendar.MONTH)))
						.append(" ").append(cal.get(Calendar.DAY_OF_MONTH))
						.append(", ").append(cal.get(Calendar.YEAR)).toString();
	}
	
	public APIResponseWrapper(T data) {
		this();
		this.data = data;
	}
	
	public APIResponseWrapper(T data, Page page) {
		this();
		this.data = data;
		this.page = page;
	}
	
	public APIResponseWrapper(String message) {
		this();
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
	
	@JsonProperty("server_date")
	public String getServerDate() {
		return serverDate;
	}
}