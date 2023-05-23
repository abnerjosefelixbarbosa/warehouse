package com.exemple.backend.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.backend.entities.Function;
import com.exemple.backend.interfaces.FunctionMethods;
import com.exemple.backend.repositories.FunctionRepository;

@Service
public class FunctionService implements FunctionMethods {
	@Autowired
	private FunctionRepository functionRepository;
	
	public String save(Function function) throws Exception {
		validCreate(function);		
		functionRepository.save(function);
		return "function save";
	}
	
	private void validCreate(Function function) throws Exception {
		if (function.getName() == null || function.getName().isEmpty())
			throw new Exception("name is null or empty");
		if (function.getName().length() > 30) 
			throw new Exception("name is greater than 30 characters");
	 	Function findByName = functionRepository.findByName(function.getName()).orElse(null);
		if (findByName != null)
			throw new Exception("existing name");
	}
	
	public List<Function> list() {
		return functionRepository.findAll();
	}
	
	public Function findById(UUID id) {
		return functionRepository.findById(id).orElse(null);
	}
	
	public Function findByName(String name) {
		return functionRepository.findByName(name).orElse(null);
	}
	
	public String updata(Function function) throws Exception {
		Function findById = findById(function.getId());
		if (findById == null) 
			return "function not found";	
		validUpdata(function);
		functionRepository.save(function);
		return "function updated";
	} 
	
	private void validUpdata(Function function) throws Exception {
		if (function.getName() == null || function.getName().isEmpty())
			throw new Exception("name is null or empty");
		if (function.getName().length() > 30) 
			throw new Exception("name is greater than 30 characters");
		Function findByName = functionRepository.findByName(function.getName()).orElse(null);
		if (findByName != null)
			throw new Exception("existing name");
	}
	
	public String deleteById(UUID id) {
		if (findById(id) == null)
			return "function not found";		
		functionRepository.deleteById(id);
		return "function deleted";
	}
}
