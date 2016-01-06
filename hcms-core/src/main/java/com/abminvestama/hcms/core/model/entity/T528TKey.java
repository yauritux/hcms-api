package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.Immutable;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Immutable
public class T528TKey implements Serializable {

	private static final long serialVersionUID = 5003745884755223626L;

	private Long plans;
	private Date endda;
	
	public T528TKey() {}
	
	public T528TKey(Long plans, Date endda) {
		this.plans = plans;
		this.endda = endda;
	}
	
	public Long getPlans() {
		return plans;
	}
	
	public Date getEndda() {
		return endda;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T528TKey key = (T528TKey) o;
		
		if (key.getPlans() != null ? (key.getPlans().longValue() != (plans != null ? plans.longValue() : 0)) : plans != null) {
			return false;
		}
		
		if (key.getEndda() != null ? (key.getEndda().compareTo(endda != null ? endda : new Date()) != 0) : endda != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = plans != null ? plans.hashCode() : 0;
		result = result * 31 + (endda != null ? endda.hashCode() : 0);
		return result;
	}
}