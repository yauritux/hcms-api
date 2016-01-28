package com.abminvestama.hcms.core.service.api.business.query;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.abminvestama.hcms.core.model.entity.T535N;
import com.abminvestama.hcms.core.model.entity.T535NKey;
import com.abminvestama.hcms.core.service.api.DatabasePaginationQueryService;
import com.abminvestama.hcms.core.service.api.DatabaseQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface T535NQueryService extends DatabaseQueryService<T535N, T535NKey>, DatabasePaginationQueryService {
	
	@NotNull
	Optional<T535N> findOneByCompositeKey(String art, String title);
}