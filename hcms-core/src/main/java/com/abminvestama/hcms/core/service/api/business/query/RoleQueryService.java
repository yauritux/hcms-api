package com.abminvestama.hcms.core.service.api.business.query;

import java.util.Optional;
import java.util.UUID;

import com.abminvestama.hcms.core.model.entity.Role;
import com.abminvestama.hcms.core.service.api.DatabaseQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * This class is a representation of 'Q' in <strong>CQRS</strong> pattern (<i>Command Query Responsibility Segregation</i>). 
 * This class contains all query operations for object <code>Role</code> in the system.
 *
 */
public interface RoleQueryService extends DatabaseQueryService<Role, UUID> {

	public Optional<Role> findByName(final Optional<String> name);
}