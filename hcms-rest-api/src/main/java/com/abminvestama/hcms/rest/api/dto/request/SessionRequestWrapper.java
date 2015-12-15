package com.abminvestama.hcms.rest.api.dto.request;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class SessionRequestWrapper {

	private String username;
	private String password;
	
	public SessionRequestWrapper() {}
	
	public SessionRequestWrapper(final String username, final String password) {
		this.username = username;
		this.password = password;
	}
	
	public final String getUsername() {
		return username;
	}
	
	public final void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}