package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;

import org.hibernate.annotations.Immutable;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Immutable
public class CSKTKey implements Serializable {

	private static final long serialVersionUID = 4467053840372711979L;

	private String kokrs;

	private String kostl;

	public CSKTKey() {
	}

	public CSKTKey(String kokrs, String kostl) {
		this.kokrs = kokrs;
		this.kostl = kostl;
	}

	public String getKokrs() {
		return kokrs;
	}

	public String getKostl() {
		return kostl;
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

		return true;
	}

	@Override
	public int hashCode() {
		int result = kokrs != null ? kokrs.hashCode() : 0;
		result = result * 31 + (kostl != null ? kostl.hashCode() : 0);
		return result;
	}
}