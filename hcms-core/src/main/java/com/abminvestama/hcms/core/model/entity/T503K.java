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
 */
@Entity
@Table(name = "t503k")
public class T503K implements Serializable {

	private static final long serialVersionUID = -3426821013690149783L;

	@Id
	@Column(name = "mandt", length = 10, unique = true, nullable = false)
	private String mandt;
	
	@Column(name = "persk", length = 255, nullable = false)
	private String persk;
	
	/**
	 * Get Employee Subgroup Code
	 * @return code of employee subgroup 
	 */
	public String getMandt() {
		return mandt;
	}
	
	/**
	 * Get Employee Subgroup Name
	 * @return name of employee subgroup
	 */
	public String getPersk() {
		return persk;
	}
	
	public void setPersk(String persk) {
		this.persk = persk;
	}
}