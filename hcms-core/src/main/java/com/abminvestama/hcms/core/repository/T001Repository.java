package com.abminvestama.hcms.core.repository;

import org.springframework.data.repository.CrudRepository;

import com.abminvestama.hcms.core.model.entity.T001;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface T001Repository extends CrudRepository<T001, String> {

	T001 findByBukrs(String bukrs);
}