package com.gsw.poc.financas.service.impl.user;

import com.gsw.poc.financas.exception.UserValidatorException;
import com.gsw.poc.financas.model.entity.user.User;
import com.gsw.poc.financas.service.interfaces.user.UserNameValidator;

public class UserNameValidatorImpl implements UserNameValidator{

	@Override
	public void isValid(User user) throws UserValidatorException {
		
		if(user.getName().length() <= 0) {
			
			throw new UserValidatorException("O campo Nome é obrigatório");
			
		}	else if(user.getName().length() <= 5 || user.getName().length() >= 50) {
			
			throw new UserValidatorException("É necessário inserir um nome válido");
			
		}
		
	}
	
}
