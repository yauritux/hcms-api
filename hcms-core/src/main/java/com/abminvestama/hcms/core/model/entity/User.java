package com.abminvestama.hcms.core.model.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * <code>User</code> class will be representing all users in the system.
 * 
 * @see Role
 */
@Entity
@Table(name = "m_user")
public class User extends AbstractEntity implements UserDetails {

	private static final long serialVersionUID = 1248987042397878045L;
	
	@Column(name = "user_name", nullable = false, unique = true)
	private String username;
	
	@Column(name = "user_email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "user_password", nullable = false)
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "user_valid_from", nullable = true)
	private Date validFrom;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "user_valid_thru", nullable = true)
	private Date validThru;
	
	@Column(name = "is_system_user", nullable = false)
	private boolean system;
	
	@Column(name = "user_auth_token")
	private String authToken;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "user_auth_token_valid_thru")
	private Date authTokenValidThru;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name = "pernr", referencedColumnName = "pernr"),
		@JoinColumn(name = "endda", referencedColumnName = "endda"),
		@JoinColumn(name = "begda", referencedColumnName = "begda")
	})
	private IT0002 employee;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_roles",
			joinColumns = { @JoinColumn(name = "m_user_id", referencedColumnName = "id") },
			inverseJoinColumns = { @JoinColumn(name = "m_role_id", referencedColumnName = "id") }
	)
	private Set<Role> roles = new HashSet<>();
	
	protected User() {
		super();
	}
	
	public User(final String username, final String password, Date validFrom, Date validThru) {
		this();
		this.username = username;
		this.password = password;
		this.validFrom = validFrom;
		this.validThru = validThru;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = this.getRoles();
		
		if (roles == null) {
			return Collections.emptyList();
		}
		
		Set<GrantedAuthority> authorities = new HashSet<>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public User setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public Date getValidFrom() {
		return validFrom;
	}
	
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	
	public Date getValidThru() {
		return validThru;
	}
	
	public void setValidThru(Date validThru) {
		this.validThru = validThru;
	}
	
	public boolean isSystem() {
		return system;
	}
	
	public User setSystem(boolean system) {
		this.system = system;
		return this;
	}
	
	public String getAuthToken() {
		return authToken;
	}
	
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
	public Date getAuthTokenValidThru() {
		return authTokenValidThru;
	}
	
	public void setAuthTokenValidThru(Date authTokenValidThru) {
		this.authTokenValidThru = authTokenValidThru;
	}
	
	/**
	 * GET Employee Information.
	 * 
	 * @return
	 */
	public IT0002 getEmployee() {
		return employee;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public User addRole(Role role) {
		this.roles.add(role);
		return this;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		if (new Date().before(this.validThru)) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		if (this.deletedAt == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isAccountNonLocked();
	}
}
