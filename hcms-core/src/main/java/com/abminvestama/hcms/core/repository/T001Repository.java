package com.abminvestama.hcms.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.abminvestama.hcms.core.model.entity.T001;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * Company Repository (DAO) Interface.
 *
 */
public interface T001Repository extends PagingAndSortingRepository<T001, String> {

	T001 findByBukrs(String bukrs);
	
	Page<T001> findAll(Pageable pageRequest);
}