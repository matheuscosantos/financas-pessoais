package com.gsw.poc.financas.service.interfaces.registry;

import com.gsw.poc.financas.exception.EntryValidatorException;
import com.gsw.poc.financas.model.entity.registry.Registry;

public interface RegistryDescriptionValidator {
	
	public void isValid(Registry registry) throws EntryValidatorException;
	
}
