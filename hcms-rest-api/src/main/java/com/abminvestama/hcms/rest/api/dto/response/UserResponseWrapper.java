package com.abminvestama.hcms.rest.api.dto.response;

import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.core.model.entity.Role;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.rest.api.model.constant.HCMSResourceIdentifier;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class UserResponseWrapper extends ResourceSupport {

	public static final String RESOURCE = HCMSResourceIdentifier.USER.label();
	
	private String uuid;
	private String username;
	private String emailAddress;
	private Role[] roles;
	
	public UserResponseWrapper(User user) {
		this.uuid = user.getId();
		this.username = user.getUsername();
		this.emailAddress = user.getEmail();
		this.roles = user.getRoles().toArray(new Role[user.getRoles().size()]);
	}
	
	@JsonProperty("system-id")
	public String getUuid() {
		return uuid;
	}
	
	@JsonProperty("username")
	public String getUsername() {
		return username;
	}
	
	@JsonProperty("email_address")
	public String getEmailAddress() {
		return emailAddress;
	}
	
	@JsonProperty("roles")
	public Role[] getRoles() {
		return roles;
	}
}