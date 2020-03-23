package com.gsw.poc.financas.service.impl.registry;

import com.gsw.poc.financas.exception.EntryValidatorException;
import com.gsw.poc.financas.model.entity.registry.Registry;
import com.gsw.poc.financas.model.enums.Type;
import com.gsw.poc.financas.service.interfaces.registry.RegistryTypeValidator;

public class RegistryTypeValidatorImpl implements RegistryTypeValidator{

	@Override
	public void isValid(Registry registry) throws EntryValidatorException {
		
		if(registry.getType().toString().isEmpty()) {
			
			throw new EntryValidatorException("O campo Tipo de Lançamento não pode ser vazio.");
			
		}else	if(!registry.getType().toString().contains("INCOME") && !registry. 	getType().toString().contains("OUTPUT")) {
			
			throw new EntryValidatorException("O Tipo de lançamento deve ser INCOME ou OUTPUT");
			
		}
		
	}

}
