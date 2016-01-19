package com.abminvestama.hcms.common.util;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public final class CommonComparatorFunction {

	public static final boolean isDifferentStringValues(String field1, String field2) {
		return (StringUtils.isNotBlank(field1) && !field1.trim().equalsIgnoreCase(field2 != null ? field2.trim() : ""));
	}
	
	public static final boolean isDifferentDateValues(Date field1, Date field2) {
		return (field1 != null && field2 != null 
				&& field1.compareTo(field2) == 0);
	}
}