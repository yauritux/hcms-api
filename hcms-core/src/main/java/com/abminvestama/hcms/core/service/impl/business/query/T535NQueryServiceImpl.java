package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T535N;
import com.abminvestama.hcms.core.model.entity.T535NKey;
import com.abminvestama.hcms.core.repository.T535NRepository;
import com.abminvestama.hcms.core.service.api.business.query.T535NQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t535nQueryService")
@Transactional(readOnly = true)
public class T535NQueryServiceImpl implements T535NQueryService {
	
	private T535NRepository t535nRepository;
	
	@Autowired
	T535NQueryServiceImpl(T535NRepository t535nRepository) {
		this.t535nRepository = t535nRepository;
	}

	@Override
	public Optional<T535N> findById(Optional<T535NKey> id) throws Exception {
		return id.map(pk -> t535nRepository.findOne(pk));
	}

	@Override
	public Optional<Collection<T535N>> fetchAll() {
		List<T535N> listOfT535N = new ArrayList<>();
		
		Optional<Iterable<T535N>> iterableT535N = Optional.ofNullable(t535nRepository.findAll());
		
		return iterableT535N.map(iter -> {
			iter.forEach(t535n -> {
				listOfT535N.add(t535n);
			});
			return listOfT535N;
		});
	}

	@Override
	public Optional<T535N> findOneByCompositeKey(String art, String title) {
		if (art == null || title == null) {
			return Optional.empty();
		}
		
		return Optional.ofNullable(t535nRepository.findOneByCompositeKey(art, title));		
	}
}