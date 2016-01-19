package com.abminvestama.hcms.rest.api.dto.helper;

import java.io.Serializable;
import java.util.Optional;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class RequestObjectComparatorContainer<E, R> implements Serializable {
	
	private E entity;
	private R requestPayload;
	
	public RequestObjectComparatorContainer(E entity, R requestPayload) {
		this.entity = entity;
		this.requestPayload = requestPayload;
	}
	
	public Optional<E> getEntity() {
		return Optional.ofNullable(entity);
	}
	
	public Optional<R> getRequestPayload() {
		return Optional.ofNullable(requestPayload);
	}

	private static final long serialVersionUID = -1511947048269850264L;
}