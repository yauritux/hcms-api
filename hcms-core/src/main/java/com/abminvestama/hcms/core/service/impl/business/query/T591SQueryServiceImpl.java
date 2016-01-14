package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T591S;
import com.abminvestama.hcms.core.repository.T591SRepository;
import com.abminvestama.hcms.core.service.api.business.query.T591SQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t591sQueryService")
@Transactional(readOnly = true)
public class T591SQueryServiceImpl implements T591SQueryService {
	
	private T591SRepository t591sRepository;
	
	@Autowired
	T591SQueryServiceImpl(T591SRepository t591sRepository) {
		this.t591sRepository = t591sRepository;
	}

	@Override
	public Optional<T591S> findById(Optional<String> id) throws Exception {
		return id.map(pk -> {
			return Optional.ofNullable(t591sRepository.findOne(pk));
		}).orElse(Optional.empty());
	}

	@Override
	public Optional<Collection<T591S>> fetchAll() {
		Optional<Iterable<T591S>> t591sIterable = Optional.ofNullable(t591sRepository.findAll());
		if (!t591sIterable.isPresent()) {
			return Optional.empty();
		}
		
		List<T591S> listOfT591S = new ArrayList<>();
		return t591sIterable.map(iteratesT591S -> {
			iteratesT591S.forEach(t591s -> {
				listOfT591S.add(t591s);
			});
			
			return listOfT591S;
		});		
	}
}