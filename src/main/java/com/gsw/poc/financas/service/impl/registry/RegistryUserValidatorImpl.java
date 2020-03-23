package com.gsw.poc.financas.service.impl.registry;

import com.gsw.poc.financas.exception.EntryValidatorException;
import com.gsw.poc.financas.model.entity.registry.Registry;
import com.gsw.poc.financas.service.interfaces.registry.RegistryUserValidator;

public class RegistryUserValidatorImpl implements RegistryUserValidator{

	@Override
	public void isValid(Registry registry) throws EntryValidatorException {
		
		if(!registry.getUser().getId().toString().isEmpty()) {
			
			throw new EntryValidatorException("O campo usuário é obrigatório");
		}
	}
}
