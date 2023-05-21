package com.exemple.backend.dto;

import com.exemple.backend.entity.Function;

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
