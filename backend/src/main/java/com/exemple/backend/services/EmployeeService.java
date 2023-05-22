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
			throw new Exception("matriculation is null");		
		if (employee.getMatriculation().toString().length() != 10)
			throw new Exception("matriculation is different than 10 characters");		
		if (employeeRepository.existsById(employee.getMatriculation()))
			throw new Exception("matriculation alread exists");		
		if (employee.getName() == null)
			throw new Exception("name is null");		
		if (employee.getName().isEmpty())
			throw new Exception("name is empty");		
		if (employee.getName().length() > 100)
			throw new Exception("name is greater than 100 characters");		
		if (employee.getSalary() == null)
			throw new Exception("salary is null");		
		if (employee.getSalary().longValue() == 0)
			throw new Exception("salary is zero");		
		if (employee.getFunction() == null)
			throw new Exception("function name not exists");		
		List<Employee> employees = employeeRepository.findByFunctionName(employee.getFunction().getName());			
		if (employees.size() == 1 && employee.getFunction().getName().equals("manager"))
			throw new Exception("manager alredy exists");		
		if (employees.size() == 3 && employee.getFunction().getName().equals("coordinator"))
			throw new Exception("coordinator alredy exists");
	}
}
