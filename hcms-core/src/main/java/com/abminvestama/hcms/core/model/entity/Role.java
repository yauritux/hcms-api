package com.abminvestama.hcms.core.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * <code>Role</code> class will be representing user's role in the system. Together with class <code>Permission</code>, this class 
 * should responsible in determining the access permission for each user registered in the system.
 * 
 * @see Permission
 *
 */
@Entity
@Table(name = "m_role")
public class Role extends AbstractEntity {

	private static final long serialVersionUID = -2074372678240011173L;

	@Column(name = "role_name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "role_description", nullable = true)
	private String description;
	
	@Column(name = "is_system_role")
	private boolean system;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "role_permissions",
			joinColumns = { @JoinColumn(name = "m_role_id", referencedColumnName = "id") },
			inverseJoinColumns = { @JoinColumn(name = "m_permission_id", referencedColumnName = "id") }
	)
	private Set<Permission> permissions = new HashSet<>();
	
	protected Role() {
		super();
	}
	
	public Role(final String name, final boolean system) {
		this();
		this.name = name;
		this.system = system;
	}
	
	public String getName() {
		return name;
	}
	
	public Role setName(final String name) {
		this.name = name;
		return this;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Role setDescription(final String description) {
		this.description = description;
		return this;
	}
	
	public boolean isSystem() {
		return system;
	}
	
	public Role setSystem(boolean system) {
		this.system = system;
		return this;
	}
	
	public Set<Permission> getPermissions() {
		return permissions;
	}
	
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public Role addPermission(Permission permission) {
		this.permissions.add(permission);
		return this;
	}
}
