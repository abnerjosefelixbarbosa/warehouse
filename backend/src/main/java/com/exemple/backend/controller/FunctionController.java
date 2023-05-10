package com.exemple.backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.backend.dto.FunctionDto;
import com.exemple.backend.entity.Function;
import com.exemple.backend.service.FunctionService;

@RestController
@RequestMapping("/functions")
public class FunctionController {
	@Autowired
	private FunctionService functionService;
	
	@GetMapping("/find-all")
	public ResponseEntity<?> findAll() {
		List<Function> functions = functionService.findAll();
		return ResponseEntity.status(200).body(functions);
	}
	
	@GetMapping("/find-by-id/{id}")
	public ResponseEntity<?> findById(@PathVariable UUID id) {
		Function functionResponse = functionService.findById(id);
		if (functionResponse == null) {
			return ResponseEntity.status(404).body(functionResponse);
		} else {
			return ResponseEntity.status(200).body(functionResponse);
		}
	}
	
	@GetMapping("/find-by-function/{function}")
	public ResponseEntity<?> findByFunction(@PathVariable String function) {
		Function functionResponse = functionService.findByFunction(function);
		if (functionResponse == null) {
			return ResponseEntity.status(404).body(functionResponse);
		} else {
			return ResponseEntity.status(200).body(functionResponse);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody FunctionDto functionDto) {
		try {
			Function function = new Function();
			BeanUtils.copyProperties(functionDto, function);
			
			functionService.validCreate(function);
			Function functionResponse = functionService.save(function);
			BeanUtils.copyProperties(functionResponse, functionDto);
			return ResponseEntity.status(200).body(functionDto);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}	
	}
}
