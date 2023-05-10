package com.exemple.backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.backend.entity.Function;
import com.exemple.backend.repository.FunctionRepository;

@Service
public class FunctionService {
	@Autowired
	private FunctionRepository functionRepository;
	
	public List<Function> findAll() {
		return functionRepository.findAll();
	}
	
	public Function findById(UUID id) {
		return functionRepository.findById(id).orElse(null);
	}
	
	public Function findByFunction(String function) {
		return functionRepository.findByFunction(function).orElse(null);
	}
	
	public void save(Function function) {
		functionRepository.save(function);
	}
	
	public void validCreate(Function function) throws Exception {
		if (function.getFunction().isEmpty()) {
			throw new Exception("function required");
		}
		if (function.getFunction().length() > 30) {
			throw new Exception("function greater than 30 characters");
		}
		if (functionRepository.existsByFunction(function.getFunction())) {
			throw new Exception("existing function");
		}
	}
	
	public void validUpdata(Function function) throws Exception {
		if (function.getFunction().isEmpty()) {
			throw new Exception("function required");
		}
		if (function.getFunction().length() > 30) {
			throw new Exception("function greater than 30 characters");
		}
		if (functionRepository.existsByFunction(function.getFunction())) {
			throw new Exception("existing function");
		}
	}
	
	public void deleteById(UUID id) {
		functionRepository.deleteById(id);
	} 
}
