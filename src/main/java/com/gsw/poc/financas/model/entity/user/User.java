package com.gsw.poc.financas.model.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotBlank(message="O nome é obrigatório")
	@Size(min=5, max=50, message="É necessário inserir um nome válido")
	private String name;
	
	@Column(nullable = false, unique = true)
	@NotBlank(message="O email é obrigatório")
	@Size(min=7, max=50, message="Tamanho do E-mail inválido")
  @Email(message="E-mail inválido")	
	private String email;	
}
