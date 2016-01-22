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

import com.abminvestama.hcms.core.model.entity.IT0022;
import com.abminvestama.hcms.core.model.entity.ITCompositeKeys;
import com.abminvestama.hcms.core.repository.IT0022Repository;
import com.abminvestama.hcms.core.service.api.business.query.IT0022QueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it0022QueryService")
@Transactional(readOnly = true)
public class IT0022QueryServiceImpl implements IT0022QueryService {

	private IT0022Repository it0022Repository;
	
	@Autowired
	IT0022QueryServiceImpl(IT0022Repository it0022Repository) {
		this.it0022Repository = it0022Repository;
	}	
	
	@Override
	public Optional<IT0022> findById(Optional<ITCompositeKeys> id) throws Exception {
		throw new NoSuchMethodException("Method not implemented. Please use method findOneByCompositeKeys instead.");
	}

	@Override
	public Optional<Collection<IT0022>> fetchAll() {
		Optional<Iterable<IT0022>> it0022Iterates = Optional.ofNullable(it0022Repository.findAll());
		if (!it0022Iterates.isPresent()) {
			return Optional.empty();
		}
		
		List<IT0022> listOfIT0022 = new ArrayList<>();
		it0022Iterates.map(it0022Iterable -> {			
			it0022Iterable.forEach(it0022 -> {
				listOfIT0022.add(it0022);
			});
			return listOfIT0022;
		});
		
		return Optional.of(listOfIT0022);
	}

	@Override
	public Optional<IT0022> findOneByCompositeKey(Long pernr, String subty, Date endda, Date begda) {
		if (pernr == null || StringUtils.isBlank(subty) || endda == null || begda == null) {
			return Optional.empty();
		}
		
		return Optional.ofNullable(it0022Repository.findOneByCompositeKey(pernr, subty, endda, begda));
	}

	@Override
	public Collection<IT0022> findByPernr(Long pernr) {
		if (pernr == null) {
			return Collections.emptyList();
		}
		
		Optional<Collection<IT0022>> bunchOfIT0022 
			= Optional.ofNullable(it0022Repository.findByPernr(pernr));
		
		return (bunchOfIT0022.isPresent()
				? bunchOfIT0022.get().stream().collect(Collectors.toList())
				: Collections.emptyList());
	}

	@Override
	public Collection<IT0022> findByPernrAndSubty(Long pernr, String subty) {
		if (pernr == null) {
			return Collections.emptyList();
		}
		
		if (StringUtils.isBlank(subty)) {
			subty = "1"; // default to subtype '1' (i.e. Permanent Residence)
		}
		
		Optional<Collection<IT0022>> bunchOfIT0022 
			= Optional.ofNullable(it0022Repository.findByPernrAndSubty(pernr, subty));

		return (bunchOfIT0022.isPresent() 
					? bunchOfIT0022.get().stream().collect(Collectors.toList())
					: Collections.emptyList());		
	}
}