package com.abminvestama.hcms.core.service.api.business.query;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.abminvestama.hcms.core.model.entity.T001;
import com.abminvestama.hcms.core.service.api.DatabasePaginationQueryService;
import com.abminvestama.hcms.core.service.api.DatabaseQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface T001QueryService extends DatabaseQueryService<T001, String>, DatabasePaginationQueryService {

	Optional<T001> findByBukrs(String bukrs);
	
	Page<T001> fetchAllWithPaging(int pageNumber);
}