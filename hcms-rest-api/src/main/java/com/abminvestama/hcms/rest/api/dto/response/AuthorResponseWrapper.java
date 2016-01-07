package com.abminvestama.hcms.rest.api.dto.response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.core.model.entity.Role;
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
		final List<RoleResponseWrapper> roleResponseWrapperList = new ArrayList<>();
		user.getRoles().stream().collect(Collectors.groupingBy(Role::getName)).values().stream().forEach(roleList -> {
			for (Role role : roleList) {
				roleResponseWrapperList.add(new RoleResponseWrapper(role));
			}
		});
		this.roles = roleResponseWrapperList.toArray(new RoleResponseWrapper[roleResponseWrapperList.size()]);
	}
	
	public AuthorResponseWrapper(final User user, final Link link) {
		this(user);
		this.add(link);
	}
	
	@JsonProperty("user_name")
	public String getUsername() {
		return username;
	}
	
	@JsonProperty("roles")
	public RoleResponseWrapper[] getRoles() {
		return roles;
	}
}