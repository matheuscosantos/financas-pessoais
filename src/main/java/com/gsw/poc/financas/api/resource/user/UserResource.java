package com.gsw.poc.financas.api.resource.user;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.gsw.poc.financas.api.dto.registry.RegistryDTO;
import com.gsw.poc.financas.api.dto.user.UserDTO;
import com.gsw.poc.financas.model.entity.registry.Registry;
import com.gsw.poc.financas.model.entity.user.User;
import com.gsw.poc.financas.service.interfaces.registry.RegistryService;
import com.gsw.poc.financas.service.interfaces.user.UserService;

@RestController
@RequestMapping("/api/user")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RegistryService registryService; 
	
	@PostMapping
	public ResponseEntity save(@RequestBody UserDTO dto) {
		User user = User.builder()
								 .name(dto.getName())
								 .email(dto.getEmail())								
								 .build();			
		try {
			User savedUser = userService.save(user);
			return new ResponseEntity(savedUser,HttpStatus.CREATED);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}	
	
	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody UserDTO dto) {
		return userService.findById(id).map( entity -> {
			try {
				User user = converter(dto);
				user.setId(entity.getId());
				userService.update(user);
				return ResponseEntity.ok(user);
			}catch(Exception e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		}).orElseGet(() -> new ResponseEntity("Usuário não encontrado.", HttpStatus.BAD_REQUEST));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		return userService.findById(id).map( entidade -> {
			userService.deleteUser(entidade);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> new ResponseEntity("Usuário não encontrado na base de Dados", HttpStatus.BAD_REQUEST));
	}
	
	@GetMapping("/listall")
	public List<User> findAllUsers(){
		return userService.findAllUsers();
	}
	
	@GetMapping("{id}/balance")
	public ResponseEntity getBalance(@PathVariable("id") Long id) {
		
		Optional<User> user = userService.findById(id);
		
		if(!user.isPresent()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		BigDecimal balance = registryService.getUserBalance(id);
		
		return ResponseEntity.ok(balance);
	}
	
	@GetMapping("{id}/incomes")
	public ResponseEntity getIncomes(@PathVariable("id") Long id) {
		
		Optional<User> user = userService.findById(id);
		
		if(!user.isPresent()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		BigDecimal incomes = registryService.getUserIncomes(id);
		
		return ResponseEntity.ok(incomes);
	}
	
	@GetMapping("{id}/outputs")
	public ResponseEntity getOutputs(@PathVariable("id") Long id) {
		
		Optional<User> user = userService.findById(id);
		
		if(!user.isPresent()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		BigDecimal outputs = registryService.getUserOutputs(id);
		
		return ResponseEntity.ok(outputs);
	}
	
	public User converter(UserDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		
		return user;
	}
	
	
}
