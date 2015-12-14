package com.abminvestama.hcms.core.service.impl.business.command;

import java.util.Date;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.exception.CannotPersistException;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.repository.UserRepository;
import com.abminvestama.hcms.core.service.api.business.command.UserCommandService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("userCommandService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class UserCommandServiceImpl implements UserCommandService {

	private UserRepository userRepository;
	
	@Autowired
	UserCommandServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public Optional<User> save(User entity, User user)
			throws CannotPersistException, NoSuchMethodException, ConstraintViolationException {
		if (entity.isNew()) {
			entity.setCreatedById(user.getId());
		}
		
		entity.setUpdatedById(user.getId());
		
		try {
			return Optional.ofNullable(userRepository.save(entity));
		} catch (Exception e) {
			throw new CannotPersistException("Cannot persist User.Reason=" + e.getMessage());
		}
	}

	@Override
	public boolean delete(User entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		entity.setDeletedById(user.getId());
		entity.setDeletedAt(new Date());
		
		return Optional.ofNullable(userRepository.save(entity)).isPresent() ? true : false;
	}

	@Override
	public boolean restore(User entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		entity.setDeletedAt(null);
		entity.setDeletedById(null);
		entity.setUpdatedById(user.getId());
		
		return Optional.ofNullable(userRepository.save(entity)).isPresent() ? true : false;
	}
}