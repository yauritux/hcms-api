package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * Class that represents master data for <strong>Job Role/Description</strong>
 *
 */
@Entity
@Table(name = "t513c")
public class T513C implements Serializable {

	private static final long serialVersionUID = -4949640312668693792L;
	
	@Id
	@Column(name = "taete", nullable = false)
	private Long taete;
	
	@Column(name = "ltext", nullable = false, length = 255)
	private String ltext;
	
	public Long getTaete() {
		return taete;
	}
	
	public String getLtext() {
		return ltext;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T513C obj = (T513C) o;
		
		if (obj.getTaete() != null ? obj.getTaete().longValue() != (taete != null ? taete.longValue() : 0L) : taete != null) {
			return false;
		}
		
		if (obj.getLtext() != null ? !obj.getLtext().equalsIgnoreCase(ltext) : ltext != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.getTaete() != null ? this.getTaete().hashCode() : 0;
		result = result * 31 + (this.ltext != null ? this.ltext.hashCode() : 0);
		return result;
	}
}