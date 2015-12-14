package com.abminvestama.hcms.core.service.api;

import java.util.Collection;
import java.util.Optional;

import com.abminvestama.hcms.core.model.entity.User;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * Common interface for database batch operations.
 *
 */
public interface DatabaseBatchCommandService<T extends java.io.Serializable> {

	public int batchDelete(Optional<Collection<T>> entities, Optional<User> user);
	
	public int batchRestore(Optional<Collection<T>> entities, Optional<User> user);
}