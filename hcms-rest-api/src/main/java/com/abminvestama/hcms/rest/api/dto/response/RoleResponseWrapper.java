package com.abminvestama.hcms.rest.api.dto.response;

import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.core.model.entity.Role;
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
public class RoleResponseWrapper extends ResourceSupport {

	private String uuid;
	private String roleName;
	private String roleDescription;
	
	public RoleResponseWrapper(Role role) {
		if (role == null) {
			return;
		}
		this.uuid = role.getId();
		this.roleName = role.getName();
		this.roleDescription = role.getDescription();
	}
	
	@JsonProperty("id")
	public String getUuid() {
		return uuid;
	}
	
	@JsonProperty("role_name")
	public String getRoleName() {
		return roleName;
	}
	
	@JsonProperty("role_description")
	public String getRoleDescription() {
		return roleDescription;
	}	
}