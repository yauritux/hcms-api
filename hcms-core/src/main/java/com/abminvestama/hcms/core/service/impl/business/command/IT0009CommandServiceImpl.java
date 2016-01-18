package com.abminvestama.hcms.core.service.impl.business.command;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.exception.CannotPersistException;
import com.abminvestama.hcms.core.model.entity.IT0009;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.repository.IT0009Repository;
import com.abminvestama.hcms.core.service.api.business.command.IT0009CommandService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it0009CommandService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class IT0009CommandServiceImpl implements IT0009CommandService {
	
	private IT0009Repository it0009Repository;
	
	@Autowired
	IT0009CommandServiceImpl(IT0009Repository it0009Repository) {
		this.it0009Repository = it0009Repository;
	}

	@Override
	public Optional<IT0009> save(IT0009 entity, User user)
			throws CannotPersistException, NoSuchMethodException, ConstraintViolationException {
		if (user != null) {
			entity.setUname(user.getId());
		}
		
		try {
			return Optional.ofNullable(it0009Repository.save(entity));
		} catch (Exception e) {
			throw new CannotPersistException("Cannot persist IT0009 (Bank Details).Reason=" + e.getMessage());
		}		
	}

	@Override
	public boolean delete(IT0009 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// no delete at this version.
		throw new NoSuchMethodException("There's no deletion on this version. Please consult to your Consultant.");
	}

	@Override
	public boolean restore(IT0009 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// since we don't have delete operation, then we don't need the 'restore' as well
		throw new NoSuchMethodException("Invalid Operation. Please consult to your Consultant.");
	}
}