package com.gsw.poc.financas.service.interfaces.user;

import com.gsw.poc.financas.exception.UserValidatorException;
import com.gsw.poc.financas.model.entity.user.User;

public interface UserNameValidator {
	
	public void isValid(User user) throws UserValidatorException;
	
}
