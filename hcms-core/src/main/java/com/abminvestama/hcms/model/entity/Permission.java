package com.abminvestama.hcms.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.abminvestama.hcms.model.constant.AccessPermissionType;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * <code>Permission</code> class represents access permission in the system.
 * 
 * @see AccessPermissionType
 */
@Entity
@Table(name = "m_permission")
public class Permission extends AbstractEntity {

	private static final long serialVersionUID = 6054632296029082276L;

	@Column(name = "permission_name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "permission_description", nullable = true)
	private String description;
	
	/**
	 * Represents object in the database. Could be <i>table</i> or <i>stored procedure</i> or <i>function</i>, or any other object 
	 * registered in the database.
	 */
	@Column(name = "permission_object", nullable = false, unique = true)
	private String object;
	
	@Column(name = "is_system_permission")
	private boolean system;
	
	@ElementCollection(targetClass = AccessPermissionType.class)
	@CollectionTable(name = "permission_accesstypes",
			joinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
	@Column(name = "access_permission_type_id")
	private Set<AccessPermissionType> accessPermissionTypes;
	
	protected Permission () {
		super();
		accessPermissionTypes = new HashSet<>();
	}
	
	public Permission(final String name, final boolean system) {
		this();
		this.name = name;
		this.system = system;
	}
	
	public String getName() {
		return name;
	}
	
	public Permission setName(final String name) {
		this.name = name;
		return this;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Permission setDescription(final String description) {
		this.description = description;
		return this;
	}
	
	public boolean isSystem() {
		return system;
	}
	
	public Permission setSystem(boolean system) {
		this.system = system;
		return this;
	}
	
	public Set<AccessPermissionType> getAccessPermissionTypes() {
		return accessPermissionTypes;
	}
	
	public void setAccessPermissionTypes(Set<AccessPermissionType> accessPermissionTypes) {
		this.accessPermissionTypes = accessPermissionTypes;
	}
	
	public Permission addAccessPermissionType(AccessPermissionType accessPermissionType) {
		this.accessPermissionTypes.add(accessPermissionType);
		return this;
	}
}
