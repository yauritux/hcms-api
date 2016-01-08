package com.abminvestama.hcms.core.service.api.business.query;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import com.abminvestama.hcms.core.model.entity.IT0006;
import com.abminvestama.hcms.core.model.entity.IT0006Key;
import com.abminvestama.hcms.core.service.api.DatabasePaginationQueryService;
import com.abminvestama.hcms.core.service.api.DatabaseQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface IT0006QueryService extends DatabaseQueryService<IT0006, IT0006Key>, DatabasePaginationQueryService {

	@NotNull
	Collection<IT0006> findByPernr(Long pernr);
	
	@NotNull
	Collection<IT0006> findByPernrAndSubty(Long pernr, String subty);
}