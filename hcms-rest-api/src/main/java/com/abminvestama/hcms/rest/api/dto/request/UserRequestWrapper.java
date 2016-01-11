package com.abminvestama.hcms.rest.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class UserRequestWrapper {

	private String username;
	private String email;
	private String password;
	private String confirmPassword;
	
	private boolean isEditRequest;
	
	public UserRequestWrapper() {}
	
	public UserRequestWrapper(String username, String password, String confirmPassword,
			String email) {
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
	}
	
	@JsonProperty("username")
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonProperty("confirm_password")
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	@JsonProperty("is_edit")
	public boolean isEditRequest() {
		return isEditRequest;
	}
	
	public void setIsEditRequest(boolean isEditRequest) {
		this.isEditRequest = isEditRequest;
	}
}