package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T001;
import com.abminvestama.hcms.core.repository.T001Repository;
import com.abminvestama.hcms.core.service.api.business.query.T001QueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t001QueryService")
@Transactional(readOnly = true)
public class T001QueryServiceImpl implements T001QueryService {
	
	private final T001Repository t001Repository;
	
	@Autowired
	T001QueryServiceImpl(T001Repository t001Repository) {
		this.t001Repository = t001Repository;
	}

	@Override
	public Optional<T001> findById(Optional<String> id) {
		return id.map(data -> Optional.ofNullable(t001Repository.findByBukrs(data))).orElse(Optional.empty());
	}

	@Override
	public Optional<Collection<T001>> fetchAll() {
		List<T001> t001List = new ArrayList<>();
		Optional<Iterable<T001>> t001Iterable = Optional.ofNullable(t001Repository.findAll());
		return t001Iterable.map(iter -> {
			iter.forEach(t001 -> t001List.add(t001));
			return t001List;
		});
	}

	@Override
	public Optional<T001> findByBukrs(String bukrs) {
		return Optional.ofNullable(t001Repository.findByBukrs(bukrs));
	}
	
	@Override
	public Page<T001> fetchAllWithPaging(int pageNumber) {
		Pageable pageRequest = createPageRequest(pageNumber);
		
		return t001Repository.findAll(pageRequest);		
	}	
}