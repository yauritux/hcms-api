package com.abminvestama.hcms.core.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.abminvestama.hcms.core.model.entity.IT0006;
import com.abminvestama.hcms.core.model.entity.IT0006Key;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface IT0006Repository extends CrudRepository<IT0006, IT0006Key> {
	
	Collection<IT0006> findByPernr(Long pernr);
}