package com.gsw.poc.financas.service.impl.registry;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsw.poc.financas.exception.EntryValidatorException;
import com.gsw.poc.financas.model.entity.registry.Registry;
import com.gsw.poc.financas.model.entity.user.User;
import com.gsw.poc.financas.model.enums.Type;
import com.gsw.poc.financas.model.repository.registry.RegistryRepository;
import com.gsw.poc.financas.service.interfaces.registry.RegistryDescriptionValidator;
import com.gsw.poc.financas.service.interfaces.registry.RegistryService;
import com.gsw.poc.financas.service.interfaces.registry.RegistryTypeValidator;
import com.gsw.poc.financas.service.interfaces.registry.RegistryUserValidator;
import com.gsw.poc.financas.service.interfaces.registry.RegistryValueValidator;

@Service
public class RegistryServiceImpl implements RegistryService{

	@Autowired
	private RegistryRepository repository;
	
	@Override
	@Transactional
	public Registry save(Registry registry) {
		
		RegistryTypeValidator registryTypeValidator = new RegistryTypeValidatorImpl();
		RegistryValueValidator registryValueValidator = new RegistryValueValidatorImpl();
		RegistryDescriptionValidator registryDescriptionValidator = new RegistryDescriptionValidatorImpl();
			
		registryTypeValidator.isValid(registry);
		registryValueValidator.isValid(registry);
		registryDescriptionValidator.isValid(registry);

		return repository.save(registry);
	}

	@Override
	@Transactional
	public Registry update(Registry registry) {
		
		Objects.requireNonNull(registry.getId());
		
		RegistryTypeValidator registryTypeValidator = new RegistryTypeValidatorImpl();
		RegistryValueValidator registryValueValidator = new RegistryValueValidatorImpl();
		RegistryDescriptionValidator registryDescriptionValidator = new RegistryDescriptionValidatorImpl();
			
		registryTypeValidator.isValid(registry);
		registryValueValidator.isValid(registry);
		registryDescriptionValidator.isValid(registry);
		
		return repository.save(registry);
	}

	@Override
	@Transactional
	public void deleteRegistry(Registry registry) {
		
		Objects.requireNonNull(registry.getId());
		
		repository.delete(registry);
		
	}

	@Override
	@Transactional
	public List<Registry> find(Registry registryFilter) {
		
		Example example = Example.of( registryFilter, ExampleMatcher.matching()
							  										  .withIgnoreCase()
							  										  .withStringMatcher(StringMatcher.CONTAINING));
		
		return repository.findAll(example);
	
	}

	@Override
	public Optional<Registry> findById(Long id) {
		return repository.findById(id);
	}
		
	@Override
	@Transactional
	public List<Registry> findAllRegistries(){
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public BigDecimal getUserBalance(Long id) {
		
		BigDecimal incomes = repository.getBalanceByTypeAndUser(id, Type.INCOME);
		BigDecimal outputs = repository.getBalanceByTypeAndUser(id, Type.OUTPUT);
		
		if(incomes == null) {
			incomes = BigDecimal.ZERO;
		}
		
		if(outputs == null) {
			outputs = BigDecimal.ZERO;
		}
		
		return incomes.subtract(outputs);
	}

	@Override
	@Transactional(readOnly = true)
	public BigDecimal getUserIncomes(Long id) {
		
		BigDecimal incomes = repository.getBalanceByTypeAndUser(id, Type.INCOME);
		
		if(incomes == null) {
			incomes = BigDecimal.ZERO;
		}
		
		return incomes;
	}

	@Override
	@Transactional(readOnly = true)
	public BigDecimal getUserOutputs(Long id) {
		
		BigDecimal outputs = repository.getBalanceByTypeAndUser(id, Type.OUTPUT);

		if(outputs == null) {
			outputs = BigDecimal.ZERO;
		}
		
		return outputs;
	}

	
	
}
