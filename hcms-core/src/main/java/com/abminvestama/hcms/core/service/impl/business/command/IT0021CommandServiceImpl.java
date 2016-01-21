package com.abminvestama.hcms.core.service.impl.business.command;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.exception.CannotPersistException;
import com.abminvestama.hcms.core.model.entity.IT0021;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.repository.IT0021Repository;
import com.abminvestama.hcms.core.service.api.business.command.IT0021CommandService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it0021CommandService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class IT0021CommandServiceImpl implements IT0021CommandService {

	private IT0021Repository it0021Repository;
	
	@Autowired
	IT0021CommandServiceImpl(IT0021Repository it0021Repository) {
		this.it0021Repository = it0021Repository;
	}
	
	@Override
	public Optional<IT0021> save(IT0021 entity, User user)
			throws CannotPersistException, NoSuchMethodException, ConstraintViolationException {
		if (user != null) {
			entity.setUname(user.getId());
		}
		
		try {
			return Optional.ofNullable(it0021Repository.save(entity));
		} catch (Exception e) {
			throw new CannotPersistException("Cannot persist IT0021 (Emergency Info).Reason=" + e.getMessage());
		}				
	}

	@Override
	public boolean delete(IT0021 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// no delete at this version.
		throw new NoSuchMethodException("There's no deletion on this version. Please consult to your Consultant.");
	}

	@Override
	public boolean restore(IT0021 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// since we don't have delete operation, then we don't need the 'restore' as well
		throw new NoSuchMethodException("Invalid Operation. Please consult to your Consultant.");
	}

}
