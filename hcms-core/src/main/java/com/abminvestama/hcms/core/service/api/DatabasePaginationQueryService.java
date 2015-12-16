package com.abminvestama.hcms.core.service.api;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface DatabasePaginationQueryService {
	
	int PAGE_SIZE = 10;

	default Pageable createPageRequest(int pageNumber) {
		return new PageRequest(pageNumber - 1, PAGE_SIZE);
	}	
}