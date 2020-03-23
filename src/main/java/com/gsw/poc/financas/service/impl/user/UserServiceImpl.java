package com.gsw.poc.financas.service.impl.user;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsw.poc.financas.model.entity.user.User;
import com.gsw.poc.financas.model.repository.user.UserRepository;
import com.gsw.poc.financas.service.interfaces.user.UserEmailValidator;
import com.gsw.poc.financas.service.interfaces.user.UserNameValidator;
import com.gsw.poc.financas.service.interfaces.user.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;
		
	@Override
	public User save(User user) {
		
		UserNameValidator userNameValidator = new UserNameValidatorImpl();
		UserEmailValidator userEmailValidator = new UserEmailValidatorImpl();
		
		userNameValidator.isValid(user);
		userEmailValidator.isValid(user);
		
		return repository.save(user);
		
	}
	
	@Override
	public Optional<User> findById(Long id) {
		
		return repository.findById(id);
		
	}
	
	@Override
	@Transactional
	public User update(User user) {
		
		UserNameValidator userNameValidator = new UserNameValidatorImpl();
		UserEmailValidator userEmailValidator = new UserEmailValidatorImpl();
		
		userNameValidator.isValid(user);
		userEmailValidator.isValid(user);
		
		return repository.save(user);
		
	}
	
	@Override
	@Transactional
	public void deleteUser(User user) {
		
		Objects.requireNonNull(user.getId());
		
		repository.delete(user);
		
	}

	@Override
	public List<User> findAllUsers() {		
		
		return repository.findAll();
		
	}
	
}
