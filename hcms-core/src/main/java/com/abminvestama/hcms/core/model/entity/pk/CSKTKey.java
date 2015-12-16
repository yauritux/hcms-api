package com.abminvestama.hcms.core.model.entity.pk;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class CSKTKey implements Serializable {

	private static final long serialVersionUID = 8589563809252688581L;

	private String kokrs;
	
	private String kostl;
	
	private Date datbi;
	
	public CSKTKey() {}
	
	public CSKTKey(String kokrs, String kostl, Date datbi) {
		this.kokrs = kokrs;
		this.kostl = kostl;
		this.datbi = datbi;
	}
	
	public String getKokrs() {
		return kokrs;
	}
	
	public String getKostl() {
		return kostl;
	}
	
	public Date getDatbi() {
		return datbi;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final CSKTKey key = (CSKTKey) o;
		
		if (kokrs != null ? !kokrs.equalsIgnoreCase(key.getKokrs()) : key.kokrs != null) {
			return false;
		}
		
		if (kostl != null ? !kostl.equalsIgnoreCase(key.getKostl()) : key.kostl != null) {
			return false;
		}
		
		if (datbi != null ? !datbi.equals(key.getDatbi()) : key.datbi != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = kokrs != null ? kokrs.hashCode() : 0;
		result = result * 31 + (kostl != null ? kostl.hashCode() : 0);
		result = result * 31 + (datbi != null ? datbi.hashCode() : 0);
		return result;
	}	
}