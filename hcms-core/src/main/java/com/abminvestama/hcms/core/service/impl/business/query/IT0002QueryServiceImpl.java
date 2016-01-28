package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.IT0002;
import com.abminvestama.hcms.core.model.entity.ITCompositeKeysNoSubtype;
import com.abminvestama.hcms.core.repository.IT0002Repository;
import com.abminvestama.hcms.core.service.api.business.query.IT0002QueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it0002QueryService")
@Transactional(readOnly = true)
public class IT0002QueryServiceImpl implements IT0002QueryService {

	private IT0002Repository it0002Repository;
	
	@Autowired
	IT0002QueryServiceImpl(IT0002Repository it0002Repository) {
		this.it0002Repository = it0002Repository;
	}
	
	@Override
	public Optional<IT0002> findById(Optional<ITCompositeKeysNoSubtype> id) throws Exception {
		return id.map(pk -> it0002Repository.findOneByCompositeKey(pk.getPernr(), pk.getEndda(), pk.getBegda()));
	}

	@Override
	public Optional<Collection<IT0002>> fetchAll() {
		Optional<Iterable<IT0002>> it0002Iterates = Optional.ofNullable(it0002Repository.findAll());
		
		List<IT0002> listOfIT0002 = new ArrayList<>();
		
		return it0002Iterates.map(it0002Iterable -> {			
			it0002Iterable.forEach(it0002 -> {
				listOfIT0002.add(it0002);
			});
			return listOfIT0002;
		});
	}

	@Override
	public Optional<IT0002> findOneByCompositeKey(Long pernr, Date endda, Date begda) {
		if (pernr == null || endda == null || begda == null) {
			return Optional.empty();
		}
		
		return Optional.ofNullable(it0002Repository.findOneByCompositeKey(pernr, endda, begda));		
	}

	@Override
	public Collection<IT0002> findByPernr(Long pernr) {
		if (pernr == null) {
			return Collections.emptyList();
		}
		
		Optional<Collection<IT0002>> bunchOfIT0002 
			= Optional.ofNullable(it0002Repository.findByPernr(pernr));
		
		return (bunchOfIT0002.isPresent()
				? bunchOfIT0002.get().stream().collect(Collectors.toList())
				: Collections.emptyList());				
	}
}