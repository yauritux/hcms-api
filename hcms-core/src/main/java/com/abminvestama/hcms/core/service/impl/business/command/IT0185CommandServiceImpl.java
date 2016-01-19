package com.abminvestama.hcms.core.service.impl.business.command;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.exception.CannotPersistException;
import com.abminvestama.hcms.core.model.entity.IT0185;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.repository.IT0185Repository;
import com.abminvestama.hcms.core.service.api.business.command.IT0185CommandService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it0185CommandService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class IT0185CommandServiceImpl implements IT0185CommandService {
	
	private IT0185Repository it0185Repository;
	
	@Autowired
	IT0185CommandServiceImpl(IT0185Repository it0185Repository) {
		this.it0185Repository = it0185Repository;
	}

	@Override
	public Optional<IT0185> save(IT0185 entity, User user)
			throws CannotPersistException, NoSuchMethodException, ConstraintViolationException {
		if (user != null) {
			entity.setUname(user.getId());
		}
		
		try {
			return Optional.ofNullable(it0185Repository.save(entity));
		} catch (Exception e) {
			throw new CannotPersistException("Cannot persist IT0185 (Personal ID).Reason=" + e.getMessage());
		}				
	}

	@Override
	public boolean delete(IT0185 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// no delete at this version.
		throw new NoSuchMethodException("There's no deletion on this version. Please consult to your Consultant.");
	}

	@Override
	public boolean restore(IT0185 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// since we don't have delete operation, then we don't need the 'restore' as well
		throw new NoSuchMethodException("Invalid Operation. Please consult to your Consultant.");
	}

}
