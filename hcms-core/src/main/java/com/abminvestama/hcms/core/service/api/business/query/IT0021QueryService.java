package com.abminvestama.hcms.core.service.api.business.query;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.abminvestama.hcms.core.model.entity.IT0021;
import com.abminvestama.hcms.core.model.entity.ITCompositeKeys;
import com.abminvestama.hcms.core.service.api.DatabasePaginationQueryService;
import com.abminvestama.hcms.core.service.api.DatabaseQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface IT0021QueryService extends DatabaseQueryService<IT0021, ITCompositeKeys>, DatabasePaginationQueryService {
	
	@NotNull
	Optional<IT0021> findOneByCompositeKey(Long pernr, String subty, Date endda, Date begda);
	
	@NotNull
	Collection<IT0021> findByPernr(Long pernr);
	
	@NotNull
	Collection<IT0021> findByPernrAndSubty(Long pernr, String subty);	
}