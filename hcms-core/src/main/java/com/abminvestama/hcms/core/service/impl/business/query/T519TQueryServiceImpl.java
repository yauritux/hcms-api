package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T519T;
import com.abminvestama.hcms.core.repository.T519TRepository;
import com.abminvestama.hcms.core.service.api.business.query.T519TQueryService;

@Service("t519tQueryService")
@Transactional(readOnly = true)
public class T519TQueryServiceImpl implements T519TQueryService {

	private T519TRepository t519tRepository;
	
	@Autowired
	T519TQueryServiceImpl(T519TRepository t519tRepository) {
		this.t519tRepository = t519tRepository;
	}
	
	@Override
	public Optional<T519T> findById(Optional<String> id) throws Exception {
		return id.map(pk -> t519tRepository.findOne(pk));
	}

	@Override
	public Optional<Collection<T519T>> fetchAll() {
		List<T519T> listOfT519T = new ArrayList<>();
		Optional<Iterable<T519T>> iterT519T = Optional.ofNullable(t519tRepository.findAll());
		return iterT519T.map(iter -> {
			iter.forEach(t519t -> {
				listOfT519T.add(t519t);
			});
			return listOfT519T;
		});
	}
}