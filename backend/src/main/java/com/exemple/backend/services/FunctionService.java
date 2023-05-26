package com.exemple.backend.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.backend.entities.Function;
import com.exemple.backend.exceptions.EntityBadRequestException;
import com.exemple.backend.exceptions.EntityNotFoundException;
import com.exemple.backend.repositories.FunctionRepository;

@Service
public class FunctionService {
	@Autowired
	private FunctionRepository functionRepository;
	
	public String save(Function function) {
		validSave(function);
		functionRepository.save(function);
		return "function saved";
	}
	
	private void validSave(Function function) {
		if (function.getName() == null || function.getName().isEmpty())
			throw new EntityBadRequestException("name is null or empty");
		if (function.getName().length() > 30) 
			throw new EntityBadRequestException("name is greater than 30 characters");
	 	Function findByName = findByName(function.getName());
		if (findByName != null)
			throw new EntityBadRequestException("existing name");
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
		validUpdata(function);
		functionRepository.save(function);
		return "function updated";
	} 
	
	private void validUpdata(Function function) {
		if (function.getId() == null)
			throw new EntityBadRequestException("id is null");
		Function findById = functionRepository.findById(function.getId()).orElse(null);
		if (findById == null)
			throw new EntityBadRequestException("id not exists");
		if (function.getName() == null || function.getName().isEmpty())
			throw new EntityBadRequestException("name is null or empty");
		if (function.getName().length() > 30) 
			throw new EntityBadRequestException("name is greater than 30 characters");
		Function findByName = functionRepository.findByName(function.getName()).orElse(null);
		if (findByName != null)
			throw new EntityBadRequestException("name exists");
	}
	
	public String deleteById(UUID id) {
	    validDelete(id);
		functionRepository.deleteById(id);
		return "function deleted";
	}
	
	private void validDelete(UUID id) {
		if (id == null)
			throw new EntityBadRequestException("id is null");
		Function findById = functionRepository.findById(id).orElse(null);
		if (findById == null)
			throw new EntityBadRequestException("id not exists");
	}
}
