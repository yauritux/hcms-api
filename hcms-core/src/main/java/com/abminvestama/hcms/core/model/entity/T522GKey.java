package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class T522GKey implements Serializable {

	private static final long serialVersionUID = -1001815676762475206L;

	private String anred;
	private String gesch;
	private String atext;
	
	public T522GKey() {}
	
	public T522GKey(String anred, String gesch, String atext) {
		this.anred = anred;
		this.gesch = gesch;
		this.atext = atext;
	}
	
	public String getAnred() {
		return anred;
	}
	
	public String getGesch() {
		return gesch;
	}
	
	public String getAtext() {
		return atext;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T522GKey key = (T522GKey) o;
		
		if (key.getAnred() != null ? !key.getAnred().equals(this.anred) : this.anred != null) {
			return false;
		}
		
		if (key.getGesch() != null ? !key.getGesch().equals(this.gesch) : this.gesch != null) {
			return false;
		}
		
		if (key.getAtext() != null ? !key.getAtext().equals(this.atext) : this.atext != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.anred != null ? this.anred.hashCode() : 0;
		result = result * 31 + (this.gesch != null ? this.gesch.hashCode() : 0);
		result = result * 31 + (this.atext != null ? this.atext.hashCode() : 0);
		return result;
	}
}