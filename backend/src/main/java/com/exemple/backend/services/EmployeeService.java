package com.exemple.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.backend.entities.Employee;
import com.exemple.backend.entities.Function;
import com.exemple.backend.interfaces.EmployeeMethods;
import com.exemple.backend.repositories.EmployeeRepository;
import com.exemple.backend.repositories.FunctionRepository;

@Service
public class EmployeeService implements EmployeeMethods {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private FunctionRepository functionRepository;
	
	public String save(Employee employee) throws Exception {
		Function function = functionRepository.findByName(employee.getFunction().getName()).orElse(null);
		employee.setFunction(function);		
		validSave(employee);
		employeeRepository.save(employee);		
		return "employee save";
	}
	
	private void validSave(Employee employee) throws Exception {
		if (employee.getMatriculation() == null)
			throw new Exception("matriculation must not be null");		
		if (employee.getMatriculation().toString().length() != 10)
			throw new Exception("matriculation can't be different fom 10 characters");
		boolean existsById = employeeRepository.existsById(employee.getMatriculation());
		if (existsById)
			throw new Exception("matriculation can't be repeated");		
		if (employee.getName() == null || employee.getName().isEmpty())
			throw new Exception("name must not be null or empty");			
		if (employee.getName().length() > 100)
			throw new Exception("name must not be greater than 100 characters");		
		if (employee.getSalary() == null || employee.getSalary().longValue() == 0)
			throw new Exception("salary must not be null or zero");				
		if (employee.getFunction() == null)
			throw new Exception("function name must exist");
		List<Employee> employees = employeeRepository.findByFunctionName(employee.getFunction().getName());	
		if (employees.size() == 1 && employee.getFunction().getName() == "manager")
			throw new Exception("there can't be more than one manager");		
		if (employees.size() == 3 && employee.getFunction().getName() == "coordinator")
			throw new Exception("there can't be more than three coordinators");
	}
}
