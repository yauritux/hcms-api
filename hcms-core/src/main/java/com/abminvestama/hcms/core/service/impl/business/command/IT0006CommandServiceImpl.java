package com.abminvestama.hcms.core.service.impl.business.command;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.exception.CannotPersistException;
import com.abminvestama.hcms.core.model.entity.IT0006;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.repository.IT0006Repository;
import com.abminvestama.hcms.core.service.api.business.command.IT0006CommandService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it0006CommandService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class IT0006CommandServiceImpl implements IT0006CommandService {
	
	private IT0006Repository it0006Repository;
	
	@Autowired
	IT0006CommandServiceImpl(IT0006Repository it0006Repository) {
		this.it0006Repository = it0006Repository;
	}

	@Override
	public Optional<IT0006> save(IT0006 entity, User user)
			throws CannotPersistException, NoSuchMethodException, ConstraintViolationException {
		if (user != null) {
			entity.setUname(user.getId());
		}
		
		try {
			return Optional.ofNullable(it0006Repository.save(entity));
		} catch (Exception e) {
			throw new CannotPersistException("Cannot persist User.Reason=" + e.getMessage());
		}		
	}

	@Override
	public boolean delete(IT0006 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// no delete at this version.
		throw new NoSuchMethodException("There's no deletion on this version. Please consult to your Consultant.");
	}

	@Override
	public boolean restore(IT0006 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// since we don't have delete operation, then we don't need the 'restore' as well
		throw new NoSuchMethodException("Invalid Operation. Please consult to your Consultant.");
	}
}