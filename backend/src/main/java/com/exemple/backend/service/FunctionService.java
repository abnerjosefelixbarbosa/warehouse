package com.exemple.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.backend.entity.Function;
import com.exemple.backend.repository.FunctionRepository;

@Service
public class FunctionService {
	@Autowired
	private FunctionRepository functionRepository;
	
	public Function save(Function function) {
		return functionRepository.save(function);
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
}
