package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Entity
@Table(name = "t513s")
@IdClass(T513SKey.class)
public class T513S implements Serializable {

	private static final long serialVersionUID = -5437960175846611668L;

	@Id
	@Column(name = "Stell", nullable = false)
	private Long stell;
	
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "endda", nullable = false)
	private Date endda;
	
	@Column(name = "begda")
	private Date begda;
	
	@Column(name = "stltx", length = 100, nullable = false)
	private String stltx;
	
	/**
	 * Get Job Key
	 * @return
	 */
	public Long getStell() {
		return stell;
	}
	
	/**
	 * Get End Date
	 * @return
	 */
	public Date getEndda() {
		return endda;
	}
	
	/**
	 * Get Start date
	 * @return
	 */
	public Date getBegda() {
		return begda;
	}
	
	/**
	 * Get Job title
	 * @return
	 */
	public String getStltx() {
		return stltx;
	}
}