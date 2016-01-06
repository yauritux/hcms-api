package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.Immutable;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Immutable
public class T513SKey implements Serializable {

	private static final long serialVersionUID = 5030687043714777922L;

	private Long stell;
	
	private Date endda;
	
	public T513SKey() {}
	
	public T513SKey(Long stell, Date endda) {
		this.stell = stell;
		this.endda = endda;
	}
	
	public Long getStell() {
		return stell;
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
		
		final T513SKey key = (T513SKey) o;
		
		if (stell != null ? (stell.longValue() != (key.getStell() != null ? key.getStell() : 0)) : key.getStell() != null) {
			return false;
		}
		
		if (endda != null ? (endda.compareTo(key.getEndda() != null ? key.getEndda() : new Date()) != 0) : key.getEndda() != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = stell != null ? stell.hashCode() : 0;
		result = result * 31 + (endda != null ? endda.hashCode() : 0);
		return result;
	}
}