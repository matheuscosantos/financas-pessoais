package com.gsw.poc.financas.service.impl.registry;

import com.gsw.poc.financas.exception.EntryValidatorException;
import com.gsw.poc.financas.model.entity.registry.Registry;
import com.gsw.poc.financas.service.interfaces.registry.RegistryDescriptionValidator;

public class RegistryDescriptionValidatorImpl implements RegistryDescriptionValidator{

	@Override
	public void isValid(Registry registry) throws EntryValidatorException {
		
		if(registry.getDescription().isEmpty()) {
			
			throw new EntryValidatorException("A descrição é obrigatória");
			
		}else if(registry.getDescription().length() < 5 || registry.getDescription().length() > 50) {
			
			throw new EntryValidatorException("A descrição deve ter entre 5 e 50 caracteres");
			
		}
		
	}

}
