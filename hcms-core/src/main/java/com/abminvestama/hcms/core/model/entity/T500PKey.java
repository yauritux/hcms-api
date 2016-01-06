package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;

import org.hibernate.annotations.Immutable;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Immutable
public class T500PKey implements Serializable {

	private static final long serialVersionUID = 6661653037461899358L;

	private String persa;
	
	private String bukrs;
	
	public T500PKey() {}
	
	public T500PKey(String persa, String bukrs) {
		this.persa = persa;
		this.bukrs = bukrs;
	}
	
	public String getPersa() {
		return persa;
	}
	
	public String getBukrs() {
		return bukrs;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T500PKey key = (T500PKey) o;
		
		if (persa != null ? !persa.equalsIgnoreCase(key.getPersa()) : key.persa != null) {
			return false;
		}
		
		if (bukrs != null ? !bukrs.equalsIgnoreCase(key.getBukrs()) : key.bukrs != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = persa != null ? persa.hashCode() : 0;
		result = result * 31 + (bukrs != null ? bukrs.hashCode() : 0);
		return result;
	}
}