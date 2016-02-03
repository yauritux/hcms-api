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
public class ITCompositeKeys implements Serializable {

	private static final long serialVersionUID = 3772040894998014331L;
	
	private Long pernr;
	private String infty;
	private String subty;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "endda", nullable = false, insertable = false, updatable = false)
	private Date endda;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "begda", nullable = false, insertable = false, updatable = false)
	private Date begda;
	
	public ITCompositeKeys() {}
	
	public ITCompositeKeys(Long pernr, String infty, String subty, Date endda, Date begda) {
		this.pernr = pernr;
		this.infty = infty;
		this.subty = subty;
		this.endda = endda;
		this.begda = begda;
	}
	
	/**
	 * GET Employee SSN.
	 * 
	 * @return
	 */
	public Long getPernr() {
		return pernr;
	}
	
	/**
	 * GET Infotype.
	 * 
	 * @return
	 */
	public String getInfty() {
		return infty;
	}
	
	/**
	 * GET Subtype.
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
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final ITCompositeKeys key = (ITCompositeKeys) o;
		
		if (key.getPernr() != null ? key.getPernr().longValue() != (pernr != null ? pernr.longValue() : 0) : pernr != null) {
			return false;
		}
		
		if (key.getInfty() != null ? !key.getInfty().equalsIgnoreCase(infty) : infty != null) {
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
		int result = this.pernr != null ? this.pernr.hashCode() : 0;
		result = result * 31 + (this.infty != null ? this.infty.hashCode() : 0);
		result = result * 31 + (this.subty != null ? this.subty.hashCode() : 0);
		result = result * 31 + (this.endda != null ? this.endda.hashCode() : 0);
		result = result * 31 + (this.begda != null ? this.begda.hashCode() : 0);
		return result;
	}
}