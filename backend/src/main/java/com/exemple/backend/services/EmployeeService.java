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
		return "employee saved";
	}
	
	private void validSave(Employee employee) {
		if (employee.getMatriculation() == null || employee.getMatriculation() == 0)
			throw new EntityBadRequestException("matriculation is null");		
		if (employee.getMatriculation().toString().length() != 10)
			throw new EntityBadRequestException("matriculation diferente of 10 characters");
		if (employeeRepository.existsById(employee.getMatriculation()))
			throw new EntityBadRequestException("matriculation exists");		
		if (employee.getName() == null || employee.getName().isEmpty())
			throw new EntityBadRequestException("name is null or empty");			
		if (employee.getName().length() > 100)
			throw new EntityBadRequestException("name is greater than 100 characters");		
		if (employee.getSalary() == null || employee.getSalary().longValue() == 0)
			throw new EntityBadRequestException("salary is null or zero");	
		Function functionFound = functionRepository.findByName(employee.getFunction().getName()).orElse(null);
		if (functionFound == null)
			throw new EntityNotFoundException("function name not found");
		employee.setFunction(functionFound);
		Long count = employeeRepository.countByFunctionName(employee.getFunction().getName());
		if (count == 1 && employee.getFunction().getName().equals("manager"))
			throw new EntityBadRequestException("1 manager exists");
		if (count == 3 && employee.getFunction().getName().equals("coordinator"))
			throw new EntityBadRequestException("3 coordinators exists");		
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
		Long count = employeeRepository.countByFunctionName(employee.getFunction().getName());
		if (count == 1 && employee.getFunction().getName().equals("manager"))
			throw new EntityBadRequestException("1 manager exists");
		if (count == 3 && employee.getFunction().getName().equals("coordinator"))
			throw new EntityBadRequestException("3 coordinators exists");
    }
    
    public String deleteByMatriculation(Long matriculation) {
    	Employee findById = employeeRepository.findById(matriculation).orElse(null);
        if (findById == null) 
        	throw new EntityNotFoundException("id not found");
    	employeeRepository.deleteById(matriculation);
    	return "employee deleted";
    }
}
