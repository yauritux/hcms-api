package com.abminvestama.hcms.core.service.api.business.query;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.service.api.DatabaseQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * This class is a representation of 'Q' in <strong>CQRS</strong> pattern (<i>Command Query Responsibility Segregation</i>). 
 * This class contains all query operations for object <code>User</code> in the system.
 *
 */
public interface UserQueryService extends DatabaseQueryService<User>, UserDetailsService {

	Optional<User> findByUsername(final Optional<String> username);
}