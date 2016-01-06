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
public class T535NKey implements Serializable {

	private static final long serialVersionUID = -4473303792875149695L;

	private String art;
	private String title;
	
	public T535NKey() {}
	
	public T535NKey(String art, String title) {
		this.art = art;
		this.title = title;
	}
	
	public String getArt() {
		return art;
	}
	
	public String getTitle() {
		return title;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T535NKey key = (T535NKey) o;
		
		if (key.getArt() != null ? !key.getArt().equals(this.getArt()) : this.getArt() != null) {
			return false;
		}
		
		if (key.getTitle() != null ? !key.getTitle().equals(this.getTitle()) : this.getTitle() != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.getArt() != null ? this.getArt().hashCode() : 0;
		result = result * 31 + (this.getTitle() != null ? this.getTitle().hashCode() : 0);
		return result;
	}
}