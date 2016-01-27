package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T513C;
import com.abminvestama.hcms.core.repository.T513CRepository;
import com.abminvestama.hcms.core.service.api.business.query.T513CQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t513cQueryService")
@Transactional(readOnly = true)
public class T513CQueryServiceImpl implements T513CQueryService {

	private T513CRepository t513cRepository;
	
	@Autowired
	T513CQueryServiceImpl(T513CRepository t513cRepository) {
		this.t513cRepository = t513cRepository;
	}
	
	@Override
	public Optional<T513C> findById(Optional<Long> id) throws Exception {
		return id.map(pk -> t513cRepository.findOne(pk));
	}

	@Override
	public Optional<Collection<T513C>> fetchAll() {
		List<T513C> listOfT513C = new ArrayList<>();
		Optional<Iterable<T513C>> bunchOfT513C = Optional.ofNullable(t513cRepository.findAll());
		return bunchOfT513C.map(iter -> {
			iter.forEach(t513c -> {
				listOfT513C.add(t513c);
			});
			return listOfT513C;
		});
	}
}