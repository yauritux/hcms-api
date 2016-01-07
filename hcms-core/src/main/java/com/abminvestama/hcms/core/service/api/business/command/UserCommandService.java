package com.abminvestama.hcms.core.service.api.business.command;

import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.service.api.DatabaseCommandService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * This class is a representation of 'C' in <strong>CQRS</strong> pattern (<i>Command Query Responsibility Segregation</i>). 
 * This class contains all command operations for object <code>User</code> in the system.
 *
 */
public interface UserCommandService extends DatabaseCommandService<User> {
}