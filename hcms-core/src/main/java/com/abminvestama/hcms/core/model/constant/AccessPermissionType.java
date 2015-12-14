package com.abminvestama.hcms.core.model.constant;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public enum AccessPermissionType {

	READ(4), WRITE(2), DELETE(1);
	
	private int accessNum;
	
	private AccessPermissionType(int accessNum) {
		this.accessNum = accessNum;
	}
	
	public int accessNum() {
		return accessNum;
	}
}
