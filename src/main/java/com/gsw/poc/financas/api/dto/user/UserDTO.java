package com.gsw.poc.financas.api.dto.user;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {
	
	private String email;
	
	private String name;
	
	private LocalDate date;
	
}
