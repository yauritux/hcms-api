package com.abminvestama.hcms.core.service.api;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * Common interface for database query. 
 */
public interface DatabaseQueryService<T extends java.io.Serializable> {

	/**
	 * Find T by it's ID.
	 * 
	 * @param id
	 * @return instance of T wrapped within Optional to avoid NPE
	 */
	public Optional<T> findById(Optional<UUID> id);
	
	/**
	 * Fetch all T entities.
	 * 
	 * @return collection of T wrapped within Optional to avoid NPE
	 */
	public Optional<Collection<T>> fetchAll();
}