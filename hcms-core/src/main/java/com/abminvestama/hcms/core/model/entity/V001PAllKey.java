package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class V001PAllKey implements Serializable {

	private static final long serialVersionUID = 6898501189782967991L;

	private String werks;
	private String btrtl;
	
	public V001PAllKey() {}
	
	public V001PAllKey(String werks, String btrtl) {
		this.werks = werks;
		this.btrtl = btrtl;
	}
	
	public String getWerks() {
		return werks;
	}
	
	public String getBtrtl() {
		return btrtl;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final V001PAllKey key = (V001PAllKey) o;
		
		if (key.getWerks() != null ? !key.getWerks().equals(this.getWerks()) : this.getWerks() != null) {
			return false;
		}
		
		if (key.getBtrtl() != null ? !key.getBtrtl().equals(this.getBtrtl()) : this.getBtrtl() != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = werks != null ? werks.hashCode() : 0;
		result = 31 * result + (btrtl != null ? btrtl.hashCode() : 0);
		return result;
	}
}