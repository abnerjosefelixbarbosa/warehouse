package com.exemple.backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.backend.entity.Function;
import com.exemple.backend.face.FunctionFace;
import com.exemple.backend.repository.FunctionRepository;

@Service
public class FunctionService implements FunctionFace {
	@Autowired
	private FunctionRepository functionRepository;
	
	public String save(Function function) throws Exception {
		validCreate(function);		
		functionRepository.save(function);
		return "function save";
	}
	
	private void validCreate(Function function) throws Exception {
		if (function.getName() == null)
			throw new Exception("function is null");
		if (function.getName().isEmpty())
			throw new Exception("function is empty");
		if (function.getName().length() > 30) 
			throw new Exception("function is greater than 30 characters");
		if (functionRepository.existsByName(function.getName()))
			throw new Exception("function already exists");
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
		if (findById(function.getId()) == null) 
			return "function not found";	
		validUpdata(function);
		functionRepository.save(function);
		return "function updated";
	} 
	
	private void validUpdata(Function function) throws Exception {
		if (function.getId() == null)
			throw new Exception("id is required");
		if (function.getName() == null || function.getName().isEmpty())
			throw new Exception("function is required");
		if (function.getName().length() > 30) 
			throw new Exception("function is greater than 30 characters");
		if (functionRepository.existsByName(function.getName()))
			throw new Exception("function already exists");
	}
	
	public String deleteById(UUID id) {
		if (findById(id) == null)
			return "function not found";		
		functionRepository.deleteById(id);
		return "function deleted";
	}
}
