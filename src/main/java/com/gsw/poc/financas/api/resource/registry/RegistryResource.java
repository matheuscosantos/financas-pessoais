package com.gsw.poc.financas.api.resource.registry;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.engine.transaction.jta.platform.internal.ResinJtaPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gsw.poc.financas.api.dto.registry.RegistryDTO;
import com.gsw.poc.financas.exception.BusinessRuleException;
import com.gsw.poc.financas.model.entity.registry.Registry;
import com.gsw.poc.financas.model.entity.user.User;
import com.gsw.poc.financas.model.enums.Type;
import com.gsw.poc.financas.service.interfaces.registry.RegistryService;
import com.gsw.poc.financas.service.interfaces.user.UserService;

@RestController
@RequestMapping("/api/lancamento")
public class RegistryResource{
	
	@Autowired
	private RegistryService registryService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity save(@RequestBody RegistryDTO dto) {
		try {
			Registry registry = converter(dto);
			registry = registryService.save(registry);
			return ResponseEntity.ok(registry);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody RegistryDTO dto) {
		return registryService.findById(id).map( entity -> {
			try {
				Registry registry = converter(dto);
				registry.setId(entity.getId());
				registryService.update(registry);
				return ResponseEntity.ok(registry);
			}catch (Exception e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}			
		}).orElseGet( () -> new ResponseEntity("Lançamento não encontrado.",HttpStatus.BAD_REQUEST));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		
		return registryService.findById(id).map( entity -> {
			
			registryService.deleteRegistry(entity);
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			
		}).orElseGet(() -> new ResponseEntity("Lançamento não encontrado na base de Dados",HttpStatus.BAD_REQUEST));
	}
	
	@GetMapping("/listar")
	public List<Registry> listarLancamentos(){
		return registryService.findAllRegistries();
	}
	
	@GetMapping
	public ResponseEntity findBy(@RequestParam(value = "description", required = false) String description,
								 							 @RequestParam(value = "type", required = false) Type type,
								 							 @RequestParam(value = "day", required = false) Integer day,
								 							 @RequestParam(value = "month", required = false) Integer month,
								 							 @RequestParam(value = "year", required = false) Integer year,
								 							 @RequestParam(value = "user") Long userId ) {
		
		Registry filterOfRegistry = new Registry();
		
		filterOfRegistry.setDescription(description);
		filterOfRegistry.setType(type);
		filterOfRegistry.setDay(day);
		filterOfRegistry.setMonth(month);
		filterOfRegistry.setYear(year);
		
		Optional<User> usuario = userService.findById(userId);
		
		if(!usuario.isPresent()) {
			
			return ResponseEntity.badRequest().body("Não foi possível realizar a consulta, usuário não encontrado.");
			
		}else {
			
			filterOfRegistry.setUser(usuario.get());
			
		}
		
		List<Registry> registries = registryService.find(filterOfRegistry);
		
		return ResponseEntity.ok(registries);
	}
	

	public Registry converter(RegistryDTO dto) {
		
		Registry registry = new Registry();
		
		registry.setDescription(dto.getDescription());
		registry.setType(dto.getType());
		registry.setValue(dto.getValue());
		registry.setDay(dto.getDay());
		registry.setMonth(dto.getMonth());
		registry.setYear(dto.getYear());
		
		User user = userService.findById(dto.getUser()).orElseThrow(() -> new BusinessRuleException("Não foi encontrado um Usuário com esse ID."));
		
		registry.setUser(user);
				
		return registry;
		
	}
	
}



















