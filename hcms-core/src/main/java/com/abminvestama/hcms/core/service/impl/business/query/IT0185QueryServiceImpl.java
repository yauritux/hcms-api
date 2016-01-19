package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.IT0185;
import com.abminvestama.hcms.core.model.entity.IT0185Key;
import com.abminvestama.hcms.core.repository.IT0185Repository;
import com.abminvestama.hcms.core.service.api.business.query.IT0185QueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it0185QueryService")
@Transactional(readOnly = true)
public class IT0185QueryServiceImpl implements IT0185QueryService {
	
	private IT0185Repository it0185Repository;
	
	@Autowired
	IT0185QueryServiceImpl(IT0185Repository it0185Repository) {
		this.it0185Repository = it0185Repository;
	}

	@Override
	public Optional<IT0185> findById(Optional<IT0185Key> id) throws Exception {
		throw new NoSuchMethodException("Method not implemented. Please use method findOneByCompositeKeys instead.");
	}

	@Override
	public Optional<Collection<IT0185>> fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<IT0185> findOneByCompositeKey(Long pernr, String subty, Date endda, Date begda) {
		if (pernr == null || StringUtils.isBlank(subty) || endda == null || begda == null) {
			return Optional.empty();
		}
		
		return Optional.ofNullable(it0185Repository.findOneByCompositeKey(pernr, subty, endda, begda));		
	}

	@Override
	public Collection<IT0185> findByPernr(Long pernr) {
		if (pernr == null) {
			return Collections.emptyList();
		}
		
		Optional<Collection<IT0185>> bunchOfIT0185 
			= Optional.ofNullable(it0185Repository.findByPernr(pernr));
		
		return (bunchOfIT0185.isPresent()
				? bunchOfIT0185.get().stream().collect(Collectors.toList())
				: Collections.emptyList());		
	}

	@Override
	public Collection<IT0185> findByPernrAndSubty(Long pernr, String subty) {
		if (pernr == null) {
			return Collections.emptyList();
		}
		
		if (StringUtils.isBlank(subty)) {
			subty = "1"; // default to subtype '1' (i.e. Permanent Residence)
		}
		
		Optional<Collection<IT0185>> bunchOfIT0185 
			= Optional.ofNullable(it0185Repository.findByPernrAndSubty(pernr, subty));

		return (bunchOfIT0185.isPresent() 
					? bunchOfIT0185.get().stream().collect(Collectors.toList())
					: Collections.emptyList());				
	}
}