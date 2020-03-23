package com.gsw.poc.financas.service.impl.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gsw.poc.financas.exception.UserValidatorException;
import com.gsw.poc.financas.model.entity.user.User;
import com.gsw.poc.financas.service.interfaces.user.UserEmailValidator;

public class UserEmailValidatorImpl implements UserEmailValidator{
	
	@Override
	public void isValid(User user) throws UserValidatorException {
		
		String regex = "[a-z._-]+@[a-z.]+";
		
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(user.getEmail());
		
		if(user.getEmail().length() <= 0) {
			
			throw new UserValidatorException("O campo email é obrigatório");	
			
		}else if(!matcher.find()) {
			
			throw new UserValidatorException("Insira um email válido");
			
		}
	}
	
}
