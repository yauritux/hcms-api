package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T5R06;
import com.abminvestama.hcms.core.repository.T5R06Repository;
import com.abminvestama.hcms.core.service.api.business.command.T5R06QueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t5r06QueryService")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class T5R06QueryServiceImpl implements T5R06QueryService {
	
	private T5R06Repository t5r06Repository;
	
	@Autowired
	T5R06QueryServiceImpl(T5R06Repository t5r06Repository) {
		this.t5r06Repository = t5r06Repository;
	}

	@Override
	public Optional<T5R06> findById(Optional<String> id) throws Exception {
		return id.map(pk -> Optional.ofNullable(t5r06Repository.findOne(pk))).orElse(Optional.empty());
	}

	@Override
	public Optional<Collection<T5R06>> fetchAll() {
		List<T5R06> listOfT5R06 = new ArrayList<>();
		
		Optional<Iterable<T5R06>> iterableT5R06 = Optional.ofNullable(t5r06Repository.findAll());
		return iterableT5R06.map(iter -> {
			iter.forEach(t5r06 -> {
				listOfT5R06.add(t5r06);
			});
			
			return listOfT5R06;
		});
	}
}