package com.abminvestama.hcms.core.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.abminvestama.hcms.core.model.entity.Role;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * This class is responsible to handle all database operations againts Role object.
 * 
 * @see Role
 */
public interface RoleRepository extends CrudRepository<Role, UUID> {

	public Role findByName(String name);
}