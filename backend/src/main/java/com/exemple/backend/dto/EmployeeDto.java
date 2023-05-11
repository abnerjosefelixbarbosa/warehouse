package com.exemple.backend.dto;

import com.exemple.backend.entity.Function;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"function"})
public class EmployeeDto {
	private Long matriculation;	
	private String employee;	
	private Double salary;		
	private Function function;	
}
