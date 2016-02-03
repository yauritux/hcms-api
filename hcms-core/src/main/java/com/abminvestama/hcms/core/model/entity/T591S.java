package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * Class that represents master data for Address Type.
 * 
 */
@Entity
@Table(name = "t591s")
public class T591S implements Serializable {

	private static final long serialVersionUID = 4399458964581160475L;

	@EmbeddedId
	private T591SKey id;
	
	@Column(name = "stext", length = 40, nullable = false)
	private String stext;
	
	public T591S() {}
	
	public T591S(T591SKey id) {
		this();
		this.id = id;
	}

	public T591SKey getId() {
		return id;
	}
	
	/**
	 * GET Name.
	 * 
	 * @return
	 */
	public String getStext() {
		return stext;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T591S obj = (T591S) o;
		
		if (obj.getId() != null ? !obj.getId().getInfty().equalsIgnoreCase(this.getId().getInfty()) : this.getId().getInfty() != null) {
			return false;
		}
		
		if (obj.getId() != null ? !obj.getId().getSubty().equalsIgnoreCase(this.getId().getSubty()) : this.getId().getSubty() != null) {
			return false;
		}
		
		if (obj.getStext() != null ? !obj.getStext().equalsIgnoreCase(this.getStext()) : this.getStext() != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.getId().getInfty() != null ? this.getId().getInfty().hashCode() : 0;
		result = result * 31 + (this.getId().getSubty() != null ? this.getId().getSubty().hashCode() : 0);
		result = result * 31 + (this.getStext() != null ? this.getStext().hashCode() : 0);
		return result;
	}
}