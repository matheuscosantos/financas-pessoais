package com.gsw.poc.financas.model.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsw.poc.financas.model.entity.user.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);

	boolean existsByEmail(String email);

}
