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

	public static final boolean isDifferentStringValues(String s1, String s2) {
		return (StringUtils.isNotBlank(s1) && !s1.trim().equalsIgnoreCase(s2 != null ? s2.trim() : ""));
	}
	
	public static final boolean isDifferentDateValues(Date d1, Date d2) {
		return (d1 != null && d2 != null 
				&& d1.compareTo(d2) != 0);
	}
	
	public static final boolean isDifferentCharacterValues(char c1, char c2) {
		return c1 == c2;
	}
	
	public static final boolean isDifferentFloatingPointNumberValues(Number n1, Number n2) {
		return n1.doubleValue() == n2.doubleValue();
	}
	
	public static final boolean isDifferentNumberValues(Number n1, Number n2) {
		return n1.longValue() == n2.longValue();
	}
}