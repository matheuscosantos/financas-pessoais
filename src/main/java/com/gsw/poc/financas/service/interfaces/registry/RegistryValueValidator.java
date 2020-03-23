package com.gsw.poc.financas.service.interfaces.registry;

import com.gsw.poc.financas.model.entity.registry.Registry;

public interface RegistryValueValidator {
	
	void isValid(Registry registry) throws RuntimeException;
	
}
