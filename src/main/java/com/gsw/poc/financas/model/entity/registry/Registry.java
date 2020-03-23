package com.gsw.poc.financas.model.entity.registry;


import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.gsw.poc.financas.model.entity.user.User;
import com.gsw.poc.financas.model.enums.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registries")
public class Registry{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotNull(message="O tipo de lançamento é obrigatório.")
	private Type type;
	
	@Column(nullable = false)
	@NotNull(message="O valor do lançamento é obrigatório")
	@Positive(message="O valor deve ser maior que R$0,00")
	private BigDecimal value;
	
	@Column(nullable = false)
	@Size(min=5, max=50, message="O tamanho da descrição deve ter  entre 5 e 50 caracteres.")
	private String description;
	
//	@Column(name = "date")
//	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
//	private LocalDate date;
	
	@Column
	private Integer day;
	
	@Column
	private Integer month;
	
	@Column
	private Integer year;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	@NotNull(message="O id no usuário deve ser válido")
	@Valid
	private User user;
	
}
