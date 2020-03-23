package com.gsw.poc.financas.service.interfaces.user;

import com.gsw.poc.financas.exception.UserValidatorException;
import com.gsw.poc.financas.model.entity.user.User;

public interface UserEmailValidator {
	
	public void isValid(User user) throws UserValidatorException;
	
}
