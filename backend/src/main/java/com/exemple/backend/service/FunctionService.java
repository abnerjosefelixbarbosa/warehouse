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
	
	public String create(Function function) throws Exception {
		validCreate(function);		
		functionRepository.save(function);
		return "function created";
	}
	
	private void validCreate(Function function) throws Exception {
		if (function.getFunction() == null)
			throw new Exception("function is null");
		if (function.getFunction().isEmpty())
			throw new Exception("function is empty");
		if (function.getFunction().length() > 30) 
			throw new Exception("function is greater than 30 characters");
		if (functionRepository.existsByFunction(function.getFunction()))
			throw new Exception("function already exists");
	}
	
	public String updata(Function function) throws Exception {
		validUpdata(function);		
		if (!functionRepository.existsById(function.getId())) 
			return "function not found";
		
		functionRepository.save(function);
		return "function updated";
	} 
	
	private void validUpdata(Function function) throws Exception {
		if (function.getId() == null)
			throw new Exception("id is null");
		if (function.getFunction() == null)
			throw new Exception("function is null");
		if (function.getFunction().isEmpty())
			throw new Exception("function is empty");
		if (function.getFunction().length() > 30) 
			throw new Exception("function is greater than 30 characters");
		if (functionRepository.existsByFunction(function.getFunction()))
			throw new Exception("function already exists");
	}
	
	public List<Function> list() {
		return functionRepository.findAll();
	}
	
	public Function findById(UUID id) {
		return functionRepository.findById(id).orElse(null);
	}
	
	public Function findByFunction(String function) {
		return functionRepository.findByFunction(function).orElse(null);
	}
	
	public String deleteById(UUID id) {
		if (!functionRepository.existsById(id))
			return "function not found";
		
		functionRepository.deleteById(id);
		return "function deleted";
	}
}
