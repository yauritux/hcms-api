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

import com.abminvestama.hcms.core.model.entity.IT0023;
import com.abminvestama.hcms.core.model.entity.ITCompositeKeysNoSubtype;
import com.abminvestama.hcms.core.repository.IT0023Repository;
import com.abminvestama.hcms.core.service.api.business.query.IT0023QueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it0023QueryService")
@Transactional(readOnly = true)
public class IT0023QueryServiceImpl implements IT0023QueryService {

	private IT0023Repository it0023Repository;
	
	@Autowired
	IT0023QueryServiceImpl(IT0023Repository it0023Repository) {
		this.it0023Repository = it0023Repository;
	}
	
	@Override
	public Optional<IT0023> findById(Optional<ITCompositeKeysNoSubtype> id) throws Exception {
		throw new NoSuchMethodException("Method not implemented. Please use method findOneByCompositeKeys instead.");		
	}

	@Override
	public Optional<Collection<IT0023>> fetchAll() {
		Optional<Iterable<IT0023>> it0023Iterates = Optional.ofNullable(it0023Repository.findAll());
		
		List<IT0023> listOfIT0023 = new ArrayList<>();
		
		return it0023Iterates.map(it0023Iterable -> {			
			it0023Iterable.forEach(it0023 -> {
				listOfIT0023.add(it0023);
			});
			return listOfIT0023;
		});
	}

	@Override
	public Optional<IT0023> findOneByCompositeKey(Long pernr, Date endda, Date begda) {
		if (pernr == null || endda == null || begda == null) {
			return Optional.empty();
		}
		
		return Optional.ofNullable(it0023Repository.findOneByCompositeKey(pernr, endda, begda));
	}

	@Override
	public Collection<IT0023> findByPernr(Long pernr) {
		if (pernr == null) {
			return Collections.emptyList();
		}
		
		Optional<Collection<IT0023>> bunchOfIT0023 
			= Optional.ofNullable(it0023Repository.findByPernr(pernr));
		
		return (bunchOfIT0023.isPresent()
				? bunchOfIT0023.get().stream().collect(Collectors.toList())
				: Collections.emptyList());		
	}
}