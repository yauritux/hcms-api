package com.abminvestama.hcms.core.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * Base entity model for SAP classes. All SAP entities should be inherited from this abstract class, 
 */
@MappedSuperclass
public abstract class SAPAbstractEntity<ID extends java.io.Serializable> implements java.io.Serializable {

	private static final long serialVersionUID = -1519710899100299783L;
	
	@EmbeddedId
	protected ID id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "aedtm", nullable = true)
	protected Date aedtm;
	
	@Column(name = "uname", nullable = true)
	protected String uname;
	
	/**
	 * Returns the id of the entity.
	 * 
	 * @return the id
	 */
	public ID getId() {
		return id;
	}
	
	public void setId(ID id) {
		this.id = id;
	}
	
	
	/**
	 * Returns the last modification date.
	 * 
	 * @return
	 */
	public Date getAedtm() {
		return aedtm;
	}
	
	/**
	 * Returns the last user changed the record.
	 * 
	 * @return the user id
	 */
	public String getUname() {
		return uname;
	}
	
	public void setUname(final String uname) {
		this.uname = uname;
	}
	
	/**
	 * Returns if the entity is new or was persisted already.
	 * 
	 * @return true if the object is new, false otherwise
	 */
	public boolean isNew() {
		return this.id == null;
	}
	
	@PrePersist
	final void prePersist() {
		this.aedtm = new Date();
	}
	
	@PreUpdate
	final void preUpdate() {
		this.aedtm = new Date();
	}	
	
	@Override
	public String toString() {
		return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		
		@SuppressWarnings("unchecked")
		final SAPAbstractEntity<ID> key = (SAPAbstractEntity<ID>) obj;
		
		if (key.id != null ? !key.getId().equals(id) : id != null) {
			return false;
		}
		
		if (key.getAedtm() != null ? key.getAedtm().compareTo(aedtm) != 0 : aedtm != null) {
			return false;
		}
		
		if (key.getUname() != null ? !key.getUname().equalsIgnoreCase(uname) : uname != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.id != null ? this.id.hashCode() : 0;
		result = result * 31 + (this.aedtm != null ? this.aedtm.hashCode() : 0);
		result = result * 31 + (this.uname != null ? this.uname.hashCode() : 0);
		return result;
	}	
}