package com.abminvestama.hcms.rest.api.dto.response;

import java.util.Calendar;

import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.common.util.CommonDateFunction;
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
	private Long pernr;
	private String fullname;
	private String photoLink;
	private String employeeStartDate;
	private String employeePosition;
	private Role[] roles;
	
	public UserResponseWrapper(User user) {
		this.uuid = user.getId();
		this.username = user.getUsername();
		this.emailAddress = user.getEmail();
		this.pernr = user.getEmployee().getPernr();
		this.fullname = user.getEmployee().getSname();
		this.photoLink = user.getPhotoLink();
		Calendar dateOfJoined = Calendar.getInstance();
		dateOfJoined.setTime(user.getEmployee().getBegda());
		this.employeeStartDate = new StringBuilder(
				CommonDateFunction.getMonthFullName(dateOfJoined.get(Calendar.MONTH))
				).append(" ").append(dateOfJoined.get(Calendar.DAY_OF_MONTH))
				.append(", ").append(dateOfJoined.get(Calendar.YEAR)).toString();
		this.employeePosition = user.getEmployee().getT528t().getPlstx();
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
	
	@JsonProperty("pernr")
	public Long getPernr() {
		return pernr;
	}
	
	@JsonProperty("fullname")
	public String getFullname() {
		return fullname;
	}
	
	@JsonProperty("photo_link")
	public String getPhotoLink() {
		return photoLink;
	}
	
	@JsonProperty("employee_start_date")
	public String getEmployeeStartDate() {
		return employeeStartDate;
	}
	
	@JsonProperty("employee_position")
	public String getEmployeePosition() {
		return employeePosition;
	}
	
	@JsonProperty("roles")
	public Role[] getRoles() {
		return roles;
	}
}