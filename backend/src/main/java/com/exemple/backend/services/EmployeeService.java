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
		validSave(employee);
		employeeRepository.save(employee);		
		return "employee save";
	}
	
	private void validSave(Employee employee) throws Exception {
		if (employee.getMatriculation() == null)
			throw new Exception("matriculation is null");		
		if (employee.getMatriculation().toString().length() != 10)
			throw new Exception("matriculation diferente of 10 characters");
		Employee findById = employeeRepository.findById(employee.getMatriculation()).orElse(null);
		if (findById != null)
			throw new Exception("existing matriculation");		
		if (employee.getName() == null || employee.getName().isEmpty())
			throw new Exception("name is null or empty");			
		if (employee.getName().length() > 100)
			throw new Exception("name is greater than 100 characters");		
		if (employee.getSalary() == null || employee.getSalary().longValue() == 0)
			throw new Exception("salary is null or zero");	
		Function findByName = functionRepository.findByName(employee.getFunction().getName()).orElse(null);
		if (findByName == null)
			throw new Exception("function name not exists");
		employee.setFunction(findByName);
		List<Employee> findByFunctionName = employeeRepository.findByFunctionName(employee.getFunction().getName());	
		if (findByFunctionName.size() == 1 && employee.getFunction().getName() == "manager")
			throw new Exception("there is already one manager");		
		if (findByFunctionName.size() == 3 && employee.getFunction().getName() == "coordinator")
			throw new Exception("there is already three coordinators");
	}
	
	public List<Employee> list() {
		return employeeRepository.findByOrderByName();
	}
}
