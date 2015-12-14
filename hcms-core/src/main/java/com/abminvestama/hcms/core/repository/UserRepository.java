package com.abminvestama.hcms.core.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.abminvestama.hcms.core.model.entity.User;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * This class is responsible to handle all database operations againts the User object.
 * 
 * @see User
 *
 */
public interface UserRepository extends CrudRepository<User, UUID> {

	@Query("FROM User u")
	List<User> fetchAllUsers();
	
	User findByUsername(String username);
	
	User findByEmail(String email);
}