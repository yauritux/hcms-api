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

import com.abminvestama.hcms.core.model.entity.IT0021;
import com.abminvestama.hcms.core.model.entity.ITCompositeKeys;
import com.abminvestama.hcms.core.repository.IT0021Repository;
import com.abminvestama.hcms.core.service.api.business.query.IT0021QueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it0021QueryService")
@Transactional(readOnly = true)
public class IT0021QueryServiceImpl implements IT0021QueryService {
	
	private IT0021Repository it0021Repository;
	
	@Autowired
	IT0021QueryServiceImpl(IT0021Repository it0021Repository) {
		this.it0021Repository = it0021Repository;
	}

	@Override
	public Optional<IT0021> findById(Optional<ITCompositeKeys> id) throws Exception {
		throw new NoSuchMethodException("Method not implemented. Please use method findOneByCompositeKeys instead.");
	}

	@Override
	public Optional<Collection<IT0021>> fetchAll() {
		Optional<Iterable<IT0021>> it0021Iterates = Optional.ofNullable(it0021Repository.findAll());
		if (!it0021Iterates.isPresent()) {
			return Optional.empty();
		}
		
		List<IT0021> listOfIT0021 = new ArrayList<>();
		it0021Iterates.map(it0021Iterable -> {			
			it0021Iterable.forEach(it0021 -> {
				listOfIT0021.add(it0021);
			});
			return listOfIT0021;
		});
		
		return Optional.of(listOfIT0021);
	}

	@Override
	public Optional<IT0021> findOneByCompositeKey(Long pernr, String subty, Date endda, Date begda) {
		if (pernr == null || StringUtils.isBlank(subty) || endda == null || begda == null) {
			return Optional.empty();
		}
		
		return Optional.ofNullable(it0021Repository.findOneByCompositeKey(pernr, subty, endda, begda));
	}

	@Override
	public Collection<IT0021> findByPernr(Long pernr) {
		if (pernr == null) {
			return Collections.emptyList();
		}
		
		Optional<Collection<IT0021>> bunchOfIT0021 
			= Optional.ofNullable(it0021Repository.findByPernr(pernr));
		
		return (bunchOfIT0021.isPresent()
				? bunchOfIT0021.get().stream().collect(Collectors.toList())
				: Collections.emptyList());
	}

	@Override
	public Collection<IT0021> findByPernrAndSubty(Long pernr, String subty) {
		if (pernr == null) {
			return Collections.emptyList();
		}
		
		if (StringUtils.isBlank(subty)) {
			subty = "1"; // default to subtype '1' (i.e. Permanent Residence)
		}
		
		Optional<Collection<IT0021>> bunchOfIT0021 
			= Optional.ofNullable(it0021Repository.findByPernrAndSubty(pernr, subty));

		return (bunchOfIT0021.isPresent() 
					? bunchOfIT0021.get().stream().collect(Collectors.toList())
					: Collections.emptyList());		
	}
}