package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T518B;
import com.abminvestama.hcms.core.repository.T518BRepository;
import com.abminvestama.hcms.core.service.api.business.query.T518BQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t518bQueryService")
@Transactional(readOnly = true)
public class T518BQueryServiceImpl implements T518BQueryService {

	private T518BRepository t518bRepository;
	
	@Autowired
	T518BQueryServiceImpl(T518BRepository t518bRepository) {
		this.t518bRepository = t518bRepository;
	}
	
	@Override
	public Optional<T518B> findById(Optional<Long> id) throws Exception {
		return id.map(pk -> t518bRepository.findOne(pk));
	}

	@Override
	public Optional<Collection<T518B>> fetchAll() {
		List<T518B> listOfT518B = new ArrayList<>();
		Optional<Iterable<T518B>> iterT518B = Optional.ofNullable(t518bRepository.findAll());
		return iterT518B.map(iter -> {
			iter.forEach(t518b -> {
				listOfT518B.add(t518b);
			});
			return listOfT518B;
		});
	}
}