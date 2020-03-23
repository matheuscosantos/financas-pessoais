package com.gsw.poc.financas.service.interfaces.registry;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.gsw.poc.financas.model.entity.registry.Registry;
import com.gsw.poc.financas.model.enums.Type;

public interface RegistryService {

	Registry save(Registry registry);
	
	Registry update(Registry registry);
	
	void deleteRegistry(Registry registry);
	
	List<Registry> find(Registry registryFilter);
	
	Optional<Registry> findById(Long id);
	
	List<Registry> findAllRegistries();
	
	BigDecimal getUserBalance(Long id);
	
	BigDecimal getUserIncomes(Long id);
	
	BigDecimal getUserOutputs(Long id);

}
