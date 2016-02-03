package com.abminvestama.hcms.core.model.constant;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public enum SAPInfoType {

	ADDRESS_DETAILS("0006"), BANK_DETAILS("0009"),
	EMERGENCY_INFO("0021"), EMPLOYEE_EDUCATION("0022"),
	PERSONAL_ID("0185"), ABSENCE_QUOTA("2006");
	
	private String infoType;
	
	private SAPInfoType(String infoType) {
		this.infoType = infoType;
	}
	
	public String infoType() {
		return infoType;
	}
}