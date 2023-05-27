package com.exemple.backend.dtos;

import com.exemple.backend.entities.Employee;
import com.exemple.backend.entities.Function;

import lombok.Data;

@Data
public class EmployeeDto {
	private Long matriculation;	
	private String name;	
	private Double salary;	
	private Function function;
	
	public Employee factoryEmployee() { 
		Employee employee = new Employee();
		employee.setMatriculation(matriculation);
		employee.setName(name);
		employee.setSalary(salary);
		employee.setFunction(function);
		return employee;
	}
}
