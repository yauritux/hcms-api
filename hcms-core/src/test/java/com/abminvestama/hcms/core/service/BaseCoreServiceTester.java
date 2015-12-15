package com.abminvestama.hcms.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.abminvestama.hcms.core.model.entity.Role;
import com.abminvestama.hcms.core.model.entity.User;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class BaseCoreServiceTester {

	public List<Role> fetchAllRoles() {
		List<Role> roles = new ArrayList<>();
		roles.add(fetchRole());
		roles.add(new Role("ROLE_ADMIN", false));
		return roles;
	}
	
	public Role fetchRole() {
		Role role = new Role("ROLE_EMPLOYEE", false);
		role.setId(UUID.randomUUID().toString());
		return role;
	}
	
	public List<User> fetchAllUsers() {
		List<User> users = new ArrayList<>();
		users.add(fetchUser());
		return users;
	}
	
	public User fetchUser() {
		User user = new User("yauritux", "abcdef12345", new Date(), new Date());
		user.setId(UUID.randomUUID().toString());
		return user;
	}
}