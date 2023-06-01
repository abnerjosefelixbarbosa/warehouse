package com.exemple.backend.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.exemple.backend.dtos.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"products"})
@EqualsAndHashCode(exclude = {"products"})
@Entity(name = "employee")
@JsonIgnoreProperties({"products"})
public class Employee {
	@Id
	@Column(nullable = false)
	private Long matriculation;	
	@Column(nullable = false, length = 100)
	private String name;	
	@Column(nullable = false)
	private Double salary;	
	@ManyToOne
	@JoinColumn(name = "function_id", nullable = false)
	private Function function;
	@OneToMany(mappedBy = "employee")
	private List<Product> products;
	
	public EmployeeDto factoryEmployeeDto() {
		EmployeeDto dto = new EmployeeDto();
		dto.setMatriculation(matriculation);
		dto.setName(name);
		dto.setSalary(salary);
		dto.setFunction(function);
		return dto;
	}
}
