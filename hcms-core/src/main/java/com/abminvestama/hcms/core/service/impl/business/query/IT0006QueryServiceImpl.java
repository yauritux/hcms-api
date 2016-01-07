package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.IT0006;
import com.abminvestama.hcms.core.model.entity.IT0006Key;
import com.abminvestama.hcms.core.repository.IT0006Repository;
import com.abminvestama.hcms.core.service.api.business.query.IT0006QueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it0006QueryService")
@Transactional(readOnly = true)
public class IT0006QueryServiceImpl implements IT0006QueryService {
	
	private IT0006Repository it0006Repository;
	
	@Autowired
	IT0006QueryServiceImpl(IT0006Repository it0006Repository) {
		this.it0006Repository = it0006Repository;
	}

	@Override
	public Optional<IT0006> findById(Optional<IT0006Key> id) {
		return id.map(pk -> {
			return it0006Repository.findOne(pk);
		});
	}

	@Override
	public Optional<Collection<IT0006>> fetchAll() {
		Optional<Iterable<IT0006>> it0006IterableRecords 
			= Optional.ofNullable(it0006Repository.findAll());
		List<IT0006> listOfIT0006 = new ArrayList<>();
		return 
			it0006IterableRecords.map(it0006Iterable -> {
				it0006Iterable.forEach(it0006 -> {
					listOfIT0006.add(it0006);
				});
				return listOfIT0006;
			});
	}

	@NotNull
	@Override
	public Collection<IT0006> findByPernr(Long pernr) {
		if (pernr == null) {
			return Collections.emptyList();
		}
		
		Optional<Collection<IT0006>> bunchOfIT0006 
			= Optional.ofNullable(it0006Repository.findByPernr(pernr));
		
		List<IT0006> listOfIT0006 = new ArrayList<>();
		return 
			bunchOfIT0006.map(it0006Collection -> {
				it0006Collection.forEach(it0006 -> {
					listOfIT0006.add(it0006);
				});
				return listOfIT0006;
			}).orElse(Collections.emptyList());
	}
}