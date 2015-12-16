package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * Class that represents Employee Group.
 */
@Entity
@Table(name = "t501t")
public class T501T implements Serializable {

	private static final long serialVersionUID = 3839359979527790333L;

	@Id
	@Column(name = "persg", length = 10, unique = true, nullable = false)
	private String persg;
	
	@Column(name = "pgtxt", length = 255, nullable = false)
	private String pgtxt;
	
	/**
	 * Get Employee Group ID
	 * @return Employee Group ID
	 */
	public String getPersg() {
		return persg;
	}
	
	/**
	 * Get Employee Group Name
	 * @return name of employee group
	 */
	public String getPgtxt() {
		return pgtxt;
	}
	
	public void setPgtxt(String pgtxt) {
		this.pgtxt = pgtxt;
	}
}