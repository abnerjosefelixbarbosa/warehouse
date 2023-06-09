package com.exemple.backend.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.backend.entities.Function;
import com.exemple.backend.exceptions.EntityBadRequestException;
import com.exemple.backend.exceptions.EntityNotFoundException;
import com.exemple.backend.interfaces.FunctionMethods;
import com.exemple.backend.repositories.FunctionRepository;

@Service
public class FunctionService implements FunctionMethods {
	@Autowired
	private FunctionRepository functionRepository;
	
	public String save(Function function) {
		validSave(function);
		UUID uuid = UUID.randomUUID();
		function.setId(uuid.toString());
		functionRepository.save(function);
		return "function saved";
	}
	
	private void validSave(Function function) {
		if (function.getName() == null || function.getName().isEmpty())
			throw new EntityBadRequestException("name is null or empty");
		if (function.getName().length() > 30) 
			throw new EntityBadRequestException("name is greater than 30 characters");
		if (functionRepository.existsByName(function.getName()))
			throw new EntityBadRequestException("name exists");
	}
	
	public List<Function> list() {
		return functionRepository.findByOrderByName();
	}
	
	public Function findByName(String name) {
		return functionRepository.findByName(name).orElseThrow(() -> {
			return new EntityNotFoundException("name not found");
		});
	}
	
	public String updata(Function function) {
		Function functionFound = functionRepository.findById(function.getId()).orElse(null);
		if (functionFound == null)
			throw new EntityNotFoundException("id not found");
		validUpdata(function);
		functionRepository.save(function);
		return "function updated";
	} 
	
	private void validUpdata(Function function) {
		if (function.getName() == null || function.getName().isEmpty())
			throw new EntityBadRequestException("name is null or empty");
		if (function.getName().length() > 30) 
			throw new EntityBadRequestException("name is greater than 30 characters");
		if (functionRepository.existsByName(function.getName()))
			throw new EntityBadRequestException("name exists");
	}
	
	public String deleteById(String id) {
	    Function functionFound = functionRepository.findById(id).orElse(null);
		if (functionFound == null)
			throw new EntityNotFoundException("id not found");
		functionRepository.deleteById(id);
		return "function deleted";
	}
}
