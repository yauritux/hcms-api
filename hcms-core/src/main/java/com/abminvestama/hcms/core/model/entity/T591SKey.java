package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Immutable;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Embeddable
@Immutable
public class T591SKey implements Serializable {

	private static final long serialVersionUID = 2987013141063448484L;
	
	@Column(name = "infty", nullable = false, insertable = false, updatable = false)
	private String infty;
	
	@Column(name = "subty", nullable = false, insertable = false, updatable = false)
	private String subty;
	
	public T591SKey() {}
	
	public T591SKey(String infty, String subty) {
		this.infty = infty;
		this.subty = subty;
	}
	
	public String getInfty() {
		return infty;
	}
	
	public String getSubty() {
		return subty;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T591SKey key = (T591SKey) o;
		
		if (key.getInfty() != null ? !key.getInfty().equalsIgnoreCase(infty) : infty != null) {
			return false;
		}
		
		if (key.getSubty() != null ? !key.getSubty().equalsIgnoreCase(subty) : subty != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.infty != null ? this.infty.hashCode() : 0;
		result = result * 31 + (this.subty != null ? this.subty.hashCode() : 0);
		return result;
	}
}