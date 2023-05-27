package com.exemple.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.backend.entities.Employee;
import com.exemple.backend.entities.Function;
import com.exemple.backend.exceptions.EntityBadRequestException;
import com.exemple.backend.exceptions.EntityNotFoundException;
import com.exemple.backend.interfaces.EmployeeMethods;
import com.exemple.backend.repositories.EmployeeRepository;
import com.exemple.backend.repositories.FunctionRepository;

@Service
public class EmployeeService implements EmployeeMethods {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private FunctionRepository functionRepository;
	
	public String save(Employee employee) {		
		validSave(employee);
		employeeRepository.save(employee);		
		return "employee save";
	}
	
	private void validSave(Employee employee) {
		if (employee.getMatriculation() == null)
			throw new EntityBadRequestException("matriculation is null");		
		if (employee.getMatriculation().toString().length() != 10)
			throw new EntityBadRequestException("matriculation diferente of 10 characters");
		Employee findById = employeeRepository.findById(employee.getMatriculation()).orElse(null);
		if (findById != null)
			throw new EntityBadRequestException("matriculation exists");		
		if (employee.getName() == null || employee.getName().isEmpty())
			throw new EntityBadRequestException("name is null or empty");			
		if (employee.getName().length() > 100)
			throw new EntityBadRequestException("name is greater than 100 characters");		
		if (employee.getSalary() == null || employee.getSalary().longValue() == 0)
			throw new EntityBadRequestException("salary is null or zero");	
		Function findByName = functionRepository.findByName(employee.getFunction().getName()).orElse(null);
		if (findByName == null)
			throw new EntityBadRequestException("function name not exists");
		employee.setFunction(findByName);
		List<Employee> findByFunctionName = employeeRepository.findByFunctionName(employee.getFunction().getName());	
		if (findByFunctionName.size() == 1 && employee.getFunction().getName() == "manager")
			throw new EntityBadRequestException("one manager exists");		
		if (findByFunctionName.size() == 3 && employee.getFunction().getName() == "coordinator")
			throw new EntityBadRequestException("three coordinators exists");
	}
	
	public List<Employee> list() {
		return employeeRepository.findByOrderByName();
	}
	
	public Employee findByMatriculation(Long matriculation) {
		return employeeRepository.findById(matriculation).orElseThrow(() -> {
			return new EntityNotFoundException("matriculation not found");
		});
	}

    public String update(Employee employee) {
    	if (employee.getMatriculation() == null)
    		throw new EntityNotFoundException("id not found");
        Employee findById = employeeRepository.findById(employee.getMatriculation()).orElse(null);
        if (findById == null) 
        	throw new EntityNotFoundException("id not found");
    	validUpdate(employee);
    	employeeRepository.save(employee);
    	return "employee updated";
    }
    
    private void validUpdate(Employee employee) {
    	if (employee.getName() == null || employee.getName().isEmpty()) 
    		throw new EntityBadRequestException("name is null or empty");
    	if (employee.getName().length() > 100)
			throw new EntityBadRequestException("name is greater than 100 characters");		
		if (employee.getSalary() == null || employee.getSalary().longValue() == 0)
			throw new EntityBadRequestException("salary is null or zero");	
		Function findByName = functionRepository.findByName(employee.getFunction().getName()).orElse(null);
		if (findByName == null)
			throw new EntityBadRequestException("function name not exists");
		employee.setFunction(findByName);
		List<Employee> findByFunctionName = employeeRepository.findByFunctionName(employee.getFunction().getName());	
		if (findByFunctionName.size() == 1 && employee.getFunction().getName() == "manager")
			throw new EntityBadRequestException("one manager exists");		
		if (findByFunctionName.size() == 3 && employee.getFunction().getName() == "coordinator")
			throw new EntityBadRequestException("three coordinators exists");
    }
}
