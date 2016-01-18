package com.abminvestama.hcms.rest.api.dto.helper;

import java.io.Serializable;
import java.util.Optional;

import com.abminvestama.hcms.core.model.entity.IT0009;
import com.abminvestama.hcms.rest.api.dto.request.IT0009RequestWrapper;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class IT0009RequestComparatorContainer implements Serializable {

	private static final long serialVersionUID = -6646051451702052373L;
	
	private IT0009 entity;
	private IT0009RequestWrapper requestPayload;
	
	public IT0009RequestComparatorContainer(IT0009 entity, IT0009RequestWrapper requestPayload) {
		this.entity = entity;
		this.requestPayload = requestPayload;
	}
	
	public Optional<IT0009> getEntity() {
		return Optional.ofNullable(entity);
	}
	
	public Optional<IT0009RequestWrapper> getRequestPayload() {
		return Optional.ofNullable(requestPayload);
	}
}