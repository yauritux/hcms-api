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
public class ITCompositeKeysNoSubtype implements Serializable {

	private static final long serialVersionUID = 5385850040856914239L;

	private Long pernr;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "endda", nullable = false, insertable = false, updatable = false)
	private Date endda;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "begda", nullable = false, insertable = false, updatable = false)
	private Date begda;
	
	public ITCompositeKeysNoSubtype() {}
	
	public ITCompositeKeysNoSubtype(Long pernr, Date endda, Date begda) {
		this.pernr = pernr;
		this.endda = endda;
		this.begda = begda;
	}
	
	/**
	 * GET Employee SSN.
	 * @return
	 */
	public Long getPernr() {
		return pernr;
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
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final ITCompositeKeysNoSubtype key = (ITCompositeKeysNoSubtype) o;
		
		if (key.getPernr() != null ? key.getPernr().longValue() != (pernr != null ? pernr.longValue() : 0L) : pernr != null) {
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
		int result = this.pernr != null ? this.pernr.hashCode() : 0;
		result = result * 31 + (this.endda != null ? this.endda.hashCode() : 0);
		result = result * 31 + (this.begda != null ? this.begda.hashCode() : 0);
		return result;
	}
}