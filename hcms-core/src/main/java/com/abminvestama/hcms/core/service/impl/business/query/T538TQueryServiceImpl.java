package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T538T;
import com.abminvestama.hcms.core.repository.T538TRepository;
import com.abminvestama.hcms.core.service.api.business.query.T538TQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t538tQueryService")
@Transactional(readOnly = true)
public class T538TQueryServiceImpl implements T538TQueryService {
	
	private T538TRepository t538tRepository;
	
	@Autowired
	T538TQueryServiceImpl(T538TRepository t538tRepository) {
		this.t538tRepository = t538tRepository;
	}

	@Override
	public Optional<T538T> findById(Optional<String> id) throws Exception {
		return id.map(pk -> t538tRepository.findOne(pk));
	}

	@Override
	public Optional<Collection<T538T>> fetchAll() {
		List<T538T> listOfT538T = new ArrayList<>();
		Optional<Iterable<T538T>> bunchOfT538T = Optional.ofNullable(t538tRepository.findAll());
		return bunchOfT538T.map(iter -> {
			iter.forEach(t538t -> {
				listOfT538T.add(t538t);
			});
			return listOfT538T;
		});
	}
}