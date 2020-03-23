package com.gsw.poc.financas.api.dto.registry;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.gsw.poc.financas.model.entity.user.User;
import com.gsw.poc.financas.model.enums.Type;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class RegistryDTO {
	
	private Long id;
	
	private Type type;
	
	private BigDecimal value;
	
	private String description;
	
	private Long user;
		
	private Integer day;
	
	private Integer month;
	
	private Integer year;

}
