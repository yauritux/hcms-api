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
 * Class that represents master table for Organizational Unit in SAP.
 *
 */
@Entity
@Table(name = "t527x")
@IdClass(T527XKey.class)
public class T527X implements Serializable {

	private static final long serialVersionUID = -1742480522634746669L;
	
	@Id
	@Column(name = "orgeh", nullable = false)
	private Long orgeh;
	
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "endda", nullable = false)
	private Date endda;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "begda")
	private Date begda;
	
	@Column(name = "orgtx", nullable = false, length = 255)
	private String orgtx;
	
	/**
	 * Get Code of Organizational Unit
	 * @return
	 */
	public Long getOrgeh() {
		return orgeh;
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
	 * Get Short text of Organizational Unit
	 * @return
	 */
	public String getOrgtx() {
		return orgtx;
	}
}