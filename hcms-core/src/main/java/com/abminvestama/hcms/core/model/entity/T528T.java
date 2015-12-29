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
 * Class that represents master table for Employee Position in SAP.
 *
 */
@Entity
@Table(name = "t528t")
@IdClass(T528TKey.class)
public class T528T implements Serializable {

	private static final long serialVersionUID = -454971926009553433L;

	@Id
	@Column(name = "plans", nullable = false)
	private Long plans;
	
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "endda", nullable = false)
	private Date endda;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "begda")
	private Date begda;
	
	@Column(name = "plstx", nullable = false, length = 150)
	private String plstx;
	
	/**
	 * Get Position Code
	 * @return
	 */
	public Long getPlans() {
		return plans;
	}
	
	/**
	 * Get End Date
	 * @return
	 */
	public Date getEndda() {
		return endda;
	}
	
	/**
	 * Get Begin Date
	 * @return
	 */
	public Date getBegda() {
		return begda;
	}
	
	/**
	 * Get Position Short Text
	 * @return
	 */
	public String getPlstx() {
		return plstx;
	}
	
	public void setPlstx(String plstx) {
		this.plstx = plstx;
	}
}