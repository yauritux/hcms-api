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
public class SessionResponseWrapper extends ResourceSupport {

	public static final String RESOURCE = HCMSResourceIdentifier.USER_SESSION.label();
	
	private String username;
	private String authToken;
	
	public SessionResponseWrapper() {}
	
	@JsonProperty("username")
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty("auth_token")
	public String getAuthToken() {
		return authToken;
	}
	
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
}