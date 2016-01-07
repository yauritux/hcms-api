package com.abminvestama.hcms.rest.api.exception.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import com.abminvestama.hcms.rest.api.model.constant.RestResponseStatus;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class ExceptionResponseWrapper extends ResourceSupport {

	private final RestResponseStatus resultStatus = RestResponseStatus.ERROR;
	private HttpStatus httpStatus;
	private HttpMethod httpMethod;
	
	private String message;
	private String field;
	
	public ExceptionResponseWrapper(String message, HttpStatus httpStatus, HttpMethod httpMethod) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.httpMethod = httpMethod;
	}
	
	public ExceptionResponseWrapper(String message, HttpStatus httpStatus, HttpMethod httpMethod, String field) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.httpMethod = httpMethod;
		this.field = field;
	}
	
	public final RestResponseStatus getResultStatus() {
		return resultStatus;
	}
	
	public final HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public final HttpMethod getHttpMethod() {
		return httpMethod;
	}
	
	public String getMessage() {
		return message;
	}
	
	public final String getField() {
		return field;
	}
	
	public void setField(String field) {
		this.field = field;
	}
	
	public static ExceptionResponseWrapper[] getErrors(Collection<FieldError> fieldErrors, HttpMethod httpMethod) {
		List<ExceptionResponseWrapper> listExceptions = new ArrayList<>();
		for (FieldError error : fieldErrors) {
			listExceptions.add(new ExceptionResponseWrapper(error.getDefaultMessage(),
					HttpStatus.EXPECTATION_FAILED,  httpMethod, error.getField()));
		}
		
		return listExceptions.toArray(new ExceptionResponseWrapper[fieldErrors.size()]);
	}
}