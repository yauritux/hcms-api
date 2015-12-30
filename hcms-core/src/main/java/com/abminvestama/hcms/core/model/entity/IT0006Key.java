package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class IT0006Key implements Serializable {

	private static final long serialVersionUID = -5819728140953219565L;

	private Long pernr;
	private String subty;
	private Date endda;
	private Date begda;
	
	public IT0006Key() {}
	
	public IT0006Key(Long pernr, String subty, Date endda, Date begda) {
		this.pernr = pernr;
		this.subty = subty;
		this.endda = endda;
		this.begda = begda;
	}
	
	/**
	 * GET Perosonnel number.
	 * 
	 * @return
	 */
	public Long getPernr() {
		return pernr;
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
		
		final IT0006Key key = (IT0006Key) o;
		
		if (key.getPernr() != null ? key.getPernr().longValue() != this.getPernr().longValue() : this.getPernr() != null) {
			return false;
		}
		
		if (key.getSubty() != null ? !key.getSubty().equals(this.getSubty()) : this.getSubty() != null) {
			return false;
		}
		
		if (key.getEndda() != null ? key.getEndda().compareTo(this.getEndda()) != 0 : this.getEndda() != null) {
			return false;
		}
		
		if (key.getBegda() != null ? key.getBegda().compareTo(this.getBegda()) != 0 : this.getBegda() != null) {
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