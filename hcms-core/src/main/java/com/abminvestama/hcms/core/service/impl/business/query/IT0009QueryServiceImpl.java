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

import com.abminvestama.hcms.core.model.entity.IT0009;
import com.abminvestama.hcms.core.model.entity.IT0009Key;
import com.abminvestama.hcms.core.repository.IT0009Repository;
import com.abminvestama.hcms.core.service.api.business.query.IT0009QueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it0009QueryService")
@Transactional(readOnly = true)
public class IT0009QueryServiceImpl implements IT0009QueryService {
	
	private IT0009Repository it0009Repository;
	
	@Autowired
	IT0009QueryServiceImpl(IT0009Repository it0009Repository) {
		this.it0009Repository = it0009Repository;
	}

	@Override
	public Optional<IT0009> findById(Optional<IT0009Key> id) throws Exception {
		throw new NoSuchMethodException("Method not implemented. Please use method findOneByCompositeKeys instead.");
	}

	@Override
	public Optional<Collection<IT0009>> fetchAll() {
		Optional<Iterable<IT0009>> it0009Iterates = Optional.ofNullable(it0009Repository.findAll());
		if (!it0009Iterates.isPresent()) {
			return Optional.empty();
		}
		
		List<IT0009> listOfIT0009 = new ArrayList<>();
		it0009Iterates.map(it0009Iterable -> {			
			it0009Iterable.forEach(it0009 -> {
				listOfIT0009.add(it0009);
			});
			return listOfIT0009;
		});
		
		return Optional.of(listOfIT0009);
	}

	@Override
	public Optional<IT0009> findOneByCompositeKey(Long pernr, String subty, Date endda, Date begda) {
		if (pernr == null || StringUtils.isBlank(subty) || endda == null || begda == null) {
			return Optional.empty();
		}
		
		return Optional.ofNullable(it0009Repository.findOneByCompositeKey(pernr, subty, endda, begda));
	}

	@Override
	public Collection<IT0009> findByPernr(Long pernr) {
		if (pernr == null) {
			return Collections.emptyList();
		}
		
		Optional<Collection<IT0009>> bunchOfIT0009 
			= Optional.ofNullable(it0009Repository.findByPernr(pernr));
		
		return (bunchOfIT0009.isPresent()
				? bunchOfIT0009.get().stream().collect(Collectors.toList())
				: Collections.emptyList());
	}

	@Override
	public Collection<IT0009> findByPernrAndSubty(Long pernr, String subty) {
		if (pernr == null) {
			return Collections.emptyList();
		}
		
		if (StringUtils.isBlank(subty)) {
			subty = "1"; // default to subtype '1' (i.e. Permanent Residence)
		}
		
		Optional<Collection<IT0009>> bunchOfIT0009 
			= Optional.ofNullable(it0009Repository.findByPernrAndSubty(pernr, subty));

		return (bunchOfIT0009.isPresent() 
					? bunchOfIT0009.get().stream().collect(Collectors.toList())
					: Collections.emptyList());		
	}
}