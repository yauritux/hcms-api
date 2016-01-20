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
public class T535NKey implements Serializable {

	private static final long serialVersionUID = -4473303792875149695L;

	@Column(name = "art", nullable = false, length = 1)	
	private String art;
	
	@Column(name = "title", nullable = false, length = 15)	
	private String title;
	
	public T535NKey() {}
	
	public T535NKey(String art, String title) {
		this.art = art;
		this.title = title;
	}
	
	/**
	 * GET Name affix type (title's type).
	 * 
	 * @return
	 */
	public String getArt() {
		return art;
	}
	
	/**
	 * GET name affix / title.
	 * 
	 * @return
	 */
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