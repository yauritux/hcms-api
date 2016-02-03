package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.IT2006;
import com.abminvestama.hcms.core.model.entity.ITCompositeKeys;
import com.abminvestama.hcms.core.repository.IT2006Repository;
import com.abminvestama.hcms.core.service.api.business.query.IT2006QueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it2006QueryService")
@Transactional(readOnly = true)
public class IT2006QueryServiceImpl implements IT2006QueryService {

	private IT2006Repository it2006Repository;
	
	@Autowired
	IT2006QueryServiceImpl(IT2006Repository it2006Repository) {
		this.it2006Repository = it2006Repository;
	}
	
	@Override
	public Optional<IT2006> findById(Optional<ITCompositeKeys> id) throws Exception {
		throw new NoSuchMethodException("Method not implemented. Please use method findOneByCompositeKeys instead.");
		
	}

	@Override
	public Optional<Collection<IT2006>> fetchAll() {
		Optional<Iterable<IT2006>> it2006Iterates = Optional.ofNullable(it2006Repository.findAll());
		if (!it2006Iterates.isPresent()) {
			return Optional.empty();
		}
		
		List<IT2006> listOfIT2006 = new ArrayList<>();
		it2006Iterates.map(it2006Iterable -> {			
			it2006Iterable.forEach(it2006 -> {
				listOfIT2006.add(it2006);
			});
			return listOfIT2006;
		});
		
		return Optional.of(listOfIT2006);
	}

	@Override
	public Optional<IT2006> findOneByCompositeKey(Long pernr, String subty, Date endda, Date begda) {
		if (pernr == null || StringUtils.isBlank(subty) || endda == null || begda == null) {
			return Optional.empty();
		}
		
		return Optional.ofNullable(it2006Repository.findOneByCompositeKey(pernr, subty, endda, begda));
	}

	@Override
	public Collection<IT2006> findByPernr(Long pernr) {
		if (pernr == null) {
			return Collections.emptyList();
		}
		
		Optional<Collection<IT2006>> bunchOfIT2006 
			= Optional.ofNullable(it2006Repository.findByPernr(pernr));
		
		return (bunchOfIT2006.isPresent()
				? bunchOfIT2006.get().stream().collect(Collectors.toList())
				: Collections.emptyList());
	}

	@Override
	public Collection<IT2006> findByPernrAndSubty(Long pernr, String subty) {
		if (pernr == null) {
			return Collections.emptyList();
		}
		
		if (StringUtils.isBlank(subty)) {
			subty = "10"; // default to subtype '1' (Quota Cuti Tahunan)
		}
		
		Optional<Collection<IT2006>> bunchOfIT2006 
			= Optional.ofNullable(it2006Repository.findByPernrAndSubty(pernr, subty));

		return (bunchOfIT2006.isPresent() 
					? bunchOfIT2006.get().stream().collect(Collectors.toList())
					: Collections.emptyList());		
	}
}