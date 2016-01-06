package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Immutable
public class T527XKey implements Serializable {

	private static final long serialVersionUID = -5693586394834010362L;

	private Long orgeh;
	
	private Date endda;
	
	public T527XKey() {}
	
	public T527XKey(Long orgeh, Date endda) {
		this.orgeh = orgeh;
		this.endda = endda;
	}
	
	public Long getOrgeh() {
		return orgeh;
	}
	
	public Date getEndda() {
		return endda;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T527XKey key = (T527XKey) o;
		
		if (key.getOrgeh() != null ? (key.getOrgeh().longValue() != (orgeh != null ? orgeh.longValue() : 0)) : orgeh != null) {
			return false;
		}
		
		if (key.getEndda() != null ? key.getEndda().compareTo(endda != null ? endda : new Date()) != 0 : endda != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = orgeh != null ? orgeh.hashCode() : 0;
		result = result * 31 + (endda != null ? endda.hashCode() : 0);
		return result;
	}
}