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
public class IT0001Key implements Serializable {

	private static final long serialVersionUID = -5123392390825515269L;

	private Long pernr;
	
	private Date endda;
	
	private Date begda;
	
	public IT0001Key() {}
	
	public IT0001Key(Long pernr, Date endda, Date begda) {
		this.pernr = pernr;
		this.endda = endda;
		this.begda = begda;
	}
	
	public Long getPernr() {
		return pernr;
	}
	
	public Date getEndda() {
		return endda;
	}
	
	public Date getBegda() {
		return begda;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final IT0001Key key = (IT0001Key) o;
		
		if (key.getPernr() != null ? key.getPernr().longValue() != (this.getPernr() != null ? this.getPernr().longValue() : 0) : this.getPernr() != null) {
			return false;
		}
		
		if (key.getEndda() != null ? (key.getEndda().compareTo(endda != null ? endda : new Date()) != 0) : endda != null) {
			return false;
		}
		
		if (key.getBegda() != null ? (key.getBegda().compareTo(begda != null ? begda : new Date()) != 0) : begda != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = pernr != null ? pernr.hashCode() : 0;
		result = 31 * result + (endda != null ? endda.hashCode() : 0);
		result = 31 * result + (begda != null ? begda.hashCode() : 0);
		return result;
	}
}