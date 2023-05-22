package com.exemple.backend.dtos;

import com.exemple.backend.entities.Function;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
	private Long matriculation;	
	private String name;	
	private Double salary;	
	private Function function;
}
