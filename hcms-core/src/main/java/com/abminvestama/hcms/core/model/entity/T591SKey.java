package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class T591SKey implements Serializable {

	private static final long serialVersionUID = 2987013141063448484L;
	
	private String infty;
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
		
		if (key.getInfty() != null ? !key.getInfty().equals(this.getInfty()) : this.getInfty() != null) {
			return false;
		}
		
		if (key.getSubty() != null ? !key.getSubty().equals(this.getSubty()) : this.getSubty() != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.getInfty() != null ? this.getInfty().hashCode() : 0;
		result = result * 31 + (this.getSubty() != null ? this.getSubty().hashCode() : 0);
		return result;
	}
}