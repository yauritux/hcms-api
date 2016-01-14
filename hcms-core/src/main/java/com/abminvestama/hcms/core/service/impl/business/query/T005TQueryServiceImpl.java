package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T005T;
import com.abminvestama.hcms.core.repository.T005TRepository;
import com.abminvestama.hcms.core.service.api.business.query.T005TQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t005tQueryService")
@Transactional(readOnly = true)
public class T005TQueryServiceImpl implements T005TQueryService {

	private T005TRepository t005tRepository;
	
	@Autowired
	T005TQueryServiceImpl(T005TRepository t005tRepository) {
		this.t005tRepository = t005tRepository;
	}
	
	@Override
	public Optional<T005T> findById(Optional<String> id) throws Exception {
		return id.map(pk -> {
			return Optional.ofNullable(t005tRepository.findOne(pk));
		}).orElse(Optional.empty());
	}

	@Override
	public Optional<Collection<T005T>> fetchAll() {
		Optional<Iterable<T005T>> iterableT005T = Optional.ofNullable(t005tRepository.findAll());
		
		List<T005T> listOfT005T = new ArrayList<>();
		
		return iterableT005T.map(t005tIterators -> {
			t005tIterators.forEach(t005t -> {
				listOfT005T.add(t005t);
			});
			return listOfT005T;
		});
	}
}