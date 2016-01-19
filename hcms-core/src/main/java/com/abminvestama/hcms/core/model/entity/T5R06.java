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
@Table(name = "t5r06")
public class T5R06 implements Serializable {

	private static final long serialVersionUID = 3669795826077668803L;
	
	@Id
	@Column(name = "ictyp", nullable = false, unique = true, length = 5)
	private String ictyp;
	
	@Column(name = "ictxt", nullable = false, length = 255)
	private String ictxt;
	
	public T5R06() {}
	
	public T5R06(String ictyp, String ictxt) {
		this.ictyp = ictyp;
		this.ictxt = ictxt;
	}
	
	/**
	 * GET IC Type.
	 * 
	 * @return
	 */
	public String getIctyp() {
		return ictyp;
	}
	
	/**
	 * GET IC Description.
	 * 
	 * @return
	 */
	public String getIctxt() {
		return ictxt;
	}
}