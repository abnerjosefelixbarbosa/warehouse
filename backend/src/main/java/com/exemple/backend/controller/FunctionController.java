package com.exemple.backend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody FunctionDto functionDto) {
		try {
			Function function = new Function();
			BeanUtils.copyProperties(functionDto, function);
			
			functionService.validCreate(function);
			function = functionService.save(function);
			BeanUtils.copyProperties(function, functionDto);
			return ResponseEntity.status(200).body(functionDto);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}	
	}
}
