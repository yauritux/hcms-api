package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.abminvestama.hcms.core.model.entity.pk.CSKTKey;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * Class that represents <strong>Cost Center</strong>.
 *
 */
@Entity
@Table(name = "cskt")
@IdClass(CSKTKey.class)
public class CSKT implements Serializable {

	private static final long serialVersionUID = 666082749895062689L;

	@Id
	@ManyToOne
	@Column(name = "kokrs", length = 10, nullable = false)
	private String kokrs;
	
	@Id
	@ManyToOne
	@Column(name = "kostl", length = 10, nullable = false)
	private String kostl;
	
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "datbi", nullable = false)
	private Date datbi;
	
	@Column(name = "ktext", length = 150, nullable = false)
	private String ktext;
	
	@Column(name = "kltxt", length = 255, nullable = true)
	private String kltxt;
	
	@Column(name = "mcds3", length = 255, nullable = false)
	private String mcds3;
	
	/**
	 * Get Controlling Area Code
	 * @return Code of Controlling Area
	 */
	public String getKokrs() {
		return kokrs;
	}
	
	/**
	 * Get Cost Center Code
	 * @return Code of Cost Center
	 */
	public String getKostl() {
		return kostl;
	}
	
	/**
	 * Get Cost Center validity period
	 * @return Date of Cost Center validity period
	 */
	public Date getDatbi() {
		return datbi;
	}
	
	/**
	 * Get Cost Center Name
	 * @return name of the Cost Center
	 */
	public String getKtext() {
		return ktext;
	}
	
	public void setKtext(String ktext) {
		this.ktext = ktext;
	}
	
	/**
	 * Get Cost Center Description
	 * @return description of Cost Center
	 */
	public String getKltxt() {
		return kltxt;
	}
	
	/**
	 * Get Cost Center Short text 
	 * @return short description of Cost Center.
	 */
	public String getMcds3() {
		return mcds3;
	}
	
	public void setMcds3(String mcds3) {
		this.mcds3 = mcds3;
	}
}