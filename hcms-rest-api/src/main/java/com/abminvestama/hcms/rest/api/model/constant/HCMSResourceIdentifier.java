package com.abminvestama.hcms.rest.api.model.constant;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public enum HCMSResourceIdentifier {

	USER_SESSION("user_session"),
	USER("user"),
	ROLE("role"),
	T001("t001"),
	SELF("self");
	
	private String label;
	
	private HCMSResourceIdentifier(String label) {
		this.label = label;
	}
	
	public String label() {
		return label;
	}
}