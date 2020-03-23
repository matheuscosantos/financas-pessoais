package com.gsw.poc.financas.service.interfaces.registry;

import com.gsw.poc.financas.exception.EntryValidatorException;
import com.gsw.poc.financas.model.entity.registry.Registry;

public interface RegistryUserValidator {
	void isValid(Registry registry) throws EntryValidatorException;
}
