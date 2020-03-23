package com.gsw.poc.financas.service.interfaces.user;
 
import java.util.List;
import java.util.Optional;

import com.gsw.poc.financas.model.entity.user.User;

public interface UserService {
		
	User save(User user);
		
	Optional<User> findById(Long id);
	
	User update(User user);

	void deleteUser(User user);

	List<User> findAllUsers();

}
