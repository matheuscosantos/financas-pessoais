package com.gsw.poc.financas.model.repository.registry;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gsw.poc.financas.model.entity.registry.Registry;
import com.gsw.poc.financas.model.enums.Type;

public interface RegistryRepository extends JpaRepository<Registry, Long>{

		@Query(value = "select sum(r.value) from Registry r join r.user u" 
								+ " where u.id = :idUser and r.type =:type group by u")		
		BigDecimal getBalanceByTypeAndUser(@Param("idUser") Long idUser, @Param("type") Type type);
	
}
