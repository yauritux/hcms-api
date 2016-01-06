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
public class IT0002Key implements Serializable {

	private static final long serialVersionUID = 2330384288628528930L;

	private Long pernr;
	
	private Date endda;
	
	private Date begda;
	
	public IT0002Key() {}
	
	public IT0002Key(Long pernr, Date endda, Date begda) {
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
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final IT0002Key key = (IT0002Key) o;
		
		if (key.getPernr() != null ? (key.getPernr().longValue() != (pernr != null ? pernr.longValue() : 0)) : pernr != null) {
			return false;
		}
		
		if (key.getEndda() != null ? key.getEndda().compareTo(endda != null ? endda : new Date()) != 0 : endda != null) {
			return false;
		}
		
		if (key.getBegda() != null ? key.getBegda().compareTo(begda != null ? begda : new Date()) != 0 : begda != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.getPernr() != null ? this.getPernr().hashCode() : 0;
		result = result * 31 + (this.getEndda() != null ? this.getEndda().hashCode() : 0);
		result = result * 31 + (this.getBegda() != null ? this.getBegda().hashCode() : 0);
		return result;
	}
}