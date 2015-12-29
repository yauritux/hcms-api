package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * Class that represents <strong>Personnel Area</strong>.
 *
 */
@Entity
@Table(name = "t500p")
@IdClass(T500PKey.class)
public class T500P implements Serializable {

	private static final long serialVersionUID = 9183005617272108480L;
	
	@Id
	@Column(name = "persa", length = 10)
	private String persa;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(name = "bukrs", referencedColumnName = "bukrs", insertable = false, updatable = false, nullable = false)
	private T001 bukrs;
	
	@Column(name = "pbtxt", length = 255, nullable = false)
	private String pbtxt;
	
	@Column(name = "name2", length = 255)
	private String name2;
	
	/**
	 * Get Personnel number
	 * @return personal ID/number
	 */
	public String getPersa() {
		return persa;
	}
	
	/**
	 * Get Company objectd
	 * @return company 
	 */
	public T001 getBukrs() {
		return bukrs;
	}
	
	/**
	 * Get Personnel Area Text
	 * @return description of personnel area
	 */
	public String getPbtxt() {
		return pbtxt;
	}
	
	/**
	 * Get Name2
	 * @return another description of personnel area
	 */
	public String getName2() {
		return name2;
	}
}