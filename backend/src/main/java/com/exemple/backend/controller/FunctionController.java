package com.exemple.backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.backend.dto.FunctionDto;
import com.exemple.backend.entity.Function;
import com.exemple.backend.face.FunctionFace;

@RestController
@RequestMapping("/functions")
public class FunctionController {
	@Autowired
	private FunctionFace functionFace;
	
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody FunctionDto functionDto) {
		try {
			Function function = new Function();
			BeanUtils.copyProperties(functionDto, function);
			String create = functionFace.create(function);
			return ResponseEntity.status(200).body(create);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}	
	}
	
	@PutMapping("/updata/{id}")
	public ResponseEntity<String> updata(@PathVariable UUID id, @RequestBody FunctionDto functionDto) {
		try {
			Function function = new Function();
			BeanUtils.copyProperties(functionDto, function);
			function.setId(id);
			
			String updata = functionFace.updata(function);
			if (updata.equals("function not found")) 
				return ResponseEntity.status(404).body(updata);
			
			return ResponseEntity.status(200).body(updata);
		} catch (Exception e) { 
			return ResponseEntity.status(400).body(e.getMessage());
		}
	} 
	
	@GetMapping("/list")
	public ResponseEntity<List<Function>> list() {
		List<Function> functions = functionFace.list();
		return ResponseEntity.status(200).body(functions);
	}
	
	@GetMapping("/find-by-id/{id}")
	public ResponseEntity<Function> findById(@PathVariable UUID id) {
		Function findById = functionFace.findById(id);
		if (findById == null) 
			return ResponseEntity.status(404).body(null);
		else 
			return ResponseEntity.status(200).body(findById);
	}
	
	@GetMapping("/find-by-function/{function}")
	public ResponseEntity<Function> findByFunction(@PathVariable String function) {
		Function findByFunction = functionFace.findByFunction(function);
		if (findByFunction == null) 
			return ResponseEntity.status(404).body(null);
		else 
			return ResponseEntity.status(200).body(findByFunction);
	}
	
	@DeleteMapping("/delete-by-id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable UUID id) {
		String deleteById = functionFace.deleteById(id);
		if (deleteById.equals("function not found")) 
			return ResponseEntity.status(404).body(deleteById);
		
		return ResponseEntity.status(200).body(deleteById);
	} 
}
