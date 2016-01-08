package com.abminvestama.hcms.rest.api.dto.response;

import java.util.stream.Collectors;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.core.model.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@JsonInclude(Include.NON_NULL)
public class AuthorResponseWrapper extends ResourceSupport {

	private String username;
	private RoleResponseWrapper[] roles;
	
	public AuthorResponseWrapper(final User user) {
		this.username = user.getUsername();
		this.roles = user.getRoles().stream().collect(Collectors.toList()).stream().map(role -> {
			return new RoleResponseWrapper(role);
		}).collect(Collectors.toList()).toArray(new RoleResponseWrapper[user.getRoles().size()]);		
	}
	
	public AuthorResponseWrapper(final User user, final Link link) {
		this(user);
		this.add(link);
	}
	
	@JsonProperty("username")
	public String getUsername() {
		return username;
	}
	
	@JsonProperty("roles")
	public RoleResponseWrapper[] getRoles() {
		return roles;
	}
}