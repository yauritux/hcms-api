package com.abminvestama.hcms.rest.api.dto.response;

import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.rest.api.model.constant.HCMSResourceIdentifier;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class T001ResponseWrapper extends ResourceSupport {

	public static final String RESOURCE = HCMSResourceIdentifier.T001.label();
	
	private String bukrs;
	private String butxt;
	
	@JsonProperty("bukrs")
	public String getBukrs() {
		return bukrs;
	}
	
	@JsonProperty("butxt")
	public String getButxt() {
		return butxt;
	}
}