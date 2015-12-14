package com.abminvestama.hcms.core.service.api;

import java.util.Optional;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import com.abminvestama.hcms.common.validation.annotation.ValidateMethod;
import com.abminvestama.hcms.core.exception.CannotPersistException;
import com.abminvestama.hcms.core.model.entity.User;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * This interface is a service based contract for database command operations.
 * All classes those are related to the database commands should implement this particular interface.
 *
 */
public interface DatabaseCommandService<T extends java.io.Serializable> {

	public Optional<T> save(@NotNull(message = "No entity to be saved") @ValidateMethod T entity,
			@NotNull(message = "user shouldn't be null or empty.") @ValidateMethod User user) 
			throws CannotPersistException, NoSuchMethodException, ConstraintViolationException;
	
	public boolean delete(@NotNull(message = "No entity to delete") @ValidateMethod T entity,
			@NotNull(message = "user shouldn't be null or empty") @ValidateMethod User user)
			throws NoSuchMethodException, ConstraintViolationException;
	
	public boolean restore(@NotNull(message = "No entity to restore") @ValidateMethod T entity,
			@NotNull(message = "user shouldn't be null or empty") @ValidateMethod User user)
			throws NoSuchMethodException, ConstraintViolationException;
} 