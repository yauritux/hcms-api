package com.abminvestama.hcms.core.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * Base entity model. All entities should be inherited from this abstract class, 
 * except for tables those inherited from SAP.
 */
@MappedSuperclass
public abstract class AbstractEntity implements Persistable<String> {

	private static final long serialVersionUID = -72616087989349546L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	protected String id;
	
	@Version
	@Column(name = "opt_lock", nullable = false)
	protected long version = 0l;
	
	@Column(name = "created_at", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("created_at")
	protected Date createdAt;
	
	@Column(name = "created_by_id", nullable = false)
	@JsonProperty("created_by_id")
	protected String createdById;
	
	@Column(name = "updated_at", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("updated_at")
	protected Date updatedAt;
	
	@Column(name = "updated_by_id", nullable = false)
	@JsonProperty("updated_by_id")
	protected String updatedById;
	
	@Column(name = "deleted_at")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("deleted_at")
	protected Date deletedAt;
	
	@Column(name = "deleted_by_id")
	@JsonProperty("deleted_by_id")
	protected String deletedById;
	
	protected AbstractEntity() {}
	
	@Override
	public String getId() {
		return id;
	}
	
	public void setId(final String id) {
		this.id = id;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public String getCreatedById() {
		return createdById;
	}
	
	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public String getUpdatedById() {
		return updatedById;
	}
	
	public void setUpdatedById(String updatedById) {
		this.updatedById = updatedById;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}
	
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	public String getDeletedById() {
		return deletedById;
	}
	
	public void setDeletedById(String deletedById) {
		this.deletedById = deletedById;
	}
	
	@Override
	public boolean isNew() {
		return this.id == null;
	}
	
	@PrePersist
	final void prePersist() {
		this.createdAt = this.updatedAt = new Date();
	}
	
	@PreUpdate
	final void preUpdate() {
		this.updatedAt = new Date();
	}
	
	@Override
	public String toString() {
		return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		
		final AbstractEntity entity = (AbstractEntity) obj;
		return this.id == null ? false : this.id.equalsIgnoreCase(entity.id);
	}
	
	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode += (this.id == null ? 0 : this.id.hashCode() * 31);
		return hashCode;
	}
}
