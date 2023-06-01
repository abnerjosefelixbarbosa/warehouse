package com.exemple.backend.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.exemple.backend.dtos.FunctionDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"employees"})
@EqualsAndHashCode(exclude = {"employees"})
@Entity(name = "function")
@JsonIgnoreProperties({"employees"})
public class Function {
	@Id
	@Column(nullable = false, length = 50)
	private String id;
	@Column(nullable = false, unique = true, length = 30)
	private String name;
	@OneToMany(mappedBy = "function")
	private List<Employee> employees;
	
	public FunctionDto factoryFunctionDto() {
		FunctionDto dto = new FunctionDto();
		dto.setId(id);
		dto.setName(name);
		return dto;
	}
}
