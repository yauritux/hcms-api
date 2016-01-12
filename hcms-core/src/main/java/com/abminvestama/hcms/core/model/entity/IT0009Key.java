package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class IT0009Key implements Serializable {

	private static final long serialVersionUID = -8308352391997548654L;

	private Long pernr;
	private String subty;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "endda", nullable = false, insertable = false, updatable = false)
	private Date endda;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "begda", nullable = false, insertable = false, updatable = false)
	private Date begda;
	
	public IT0009Key() {}
	
	public IT0009Key(Long pernr, String subty, Date endda, Date begda) {
		this.pernr = pernr;
		this.subty = subty;
		this.endda = endda;
		this.begda = begda;
	}
	
	/**
	 * GET Employee SSN (pernr)
	 * 
	 * @return
	 */
	public Long getPernr() {
		return pernr;
	}
	
	/**
	 * GET Address Subtype.
	 * 
	 * @return
	 */
	public String getSubty() {
		return subty;
	}
	
	/**
	 * GET End Date.
	 * 
	 * @return
	 */
	public Date getEndda() {
		return endda;
	}
	
	/**
	 * GET Begin Date.
	 * 
	 * @return
	 */
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
		
		final IT0009Key key = (IT0009Key) o;
		
		if (key.getPernr() != null ? key.getPernr().longValue() != pernr.longValue() : pernr != null) {
			return false;
		}
		
		if (key.getSubty() != null ? !key.getSubty().equalsIgnoreCase(subty) : subty != null) {
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
		result = result * 31 + (this.getSubty() != null ? this.getSubty().hashCode() : 0);
		result = result * 31 + (this.getEndda() != null ? this.getEndda().hashCode() : 0);
		result = result * 31 + (this.getBegda() != null ? this.getBegda().hashCode() : 0);
		return result;
	}
} 