package com.gsw.poc.financas.service.impl.registry;

import com.gsw.poc.financas.exception.EntryValidatorException;
import com.gsw.poc.financas.model.entity.registry.Registry;
import com.gsw.poc.financas.service.interfaces.registry.RegistryValueValidator;

public class RegistryValueValidatorImpl implements RegistryValueValidator {

	@Override
	public void isValid(Registry registry) throws RuntimeException {

		if (registry.getValue() == null || registry.getValue().doubleValue() <= 0) {
				
			throw new EntryValidatorException("O valor precisa ser um número positivo.");

		}
	}
}
