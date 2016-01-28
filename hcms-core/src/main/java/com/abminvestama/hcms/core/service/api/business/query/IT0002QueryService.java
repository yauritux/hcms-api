package com.abminvestama.hcms.core.service.api.business.query;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.abminvestama.hcms.core.model.entity.IT0002;
import com.abminvestama.hcms.core.model.entity.ITCompositeKeysNoSubtype;
import com.abminvestama.hcms.core.service.api.DatabasePaginationQueryService;
import com.abminvestama.hcms.core.service.api.DatabaseQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface IT0002QueryService extends DatabaseQueryService<IT0002, ITCompositeKeysNoSubtype>, DatabasePaginationQueryService {
	
	@NotNull
	Optional<IT0002> findOneByCompositeKey(Long pernr, Date endda, Date begda);
	
	@NotNull
	Collection<IT0002> findByPernr(Long pernr);		
}