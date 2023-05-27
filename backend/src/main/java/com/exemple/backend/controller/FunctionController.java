package com.exemple.backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.backend.dtos.FunctionDto;
import com.exemple.backend.entities.Function;
import com.exemple.backend.interfaces.FunctionMethods;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/functions")
public class FunctionController {
	@Autowired
	private FunctionMethods functionMethods;
	
	@ApiOperation("save")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Created"),
		@ApiResponse(code = 400, message = "Bad request")
	})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody FunctionDto functionDto) {
		Function function = functionDto.factoryFunction();
		String save = functionMethods.save(function);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);	
	}
	
	@ApiOperation("list")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ok")
	})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/list")
	public ResponseEntity<List<Function>> list() {
		List<Function> functions = functionMethods.list();
		return ResponseEntity.status(HttpStatus.OK).body(functions);
	}
	
	@ApiOperation("find by name")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ok"),
		@ApiResponse(code = 404, message = "Not found")
	})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/find-by-name")
	public ResponseEntity<Function> findByName(@RequestParam(required = false) String name) {
		Function findByFunction = functionMethods.findByName(name);
	    return ResponseEntity.status(HttpStatus.OK).body(findByFunction);
	}
	
	@ApiOperation("update")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ok"),
		@ApiResponse(code = 404, message = "Not find"),
		@ApiResponse(code = 400, message = "Bad request")
	})
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable UUID id, @RequestBody FunctionDto functionDto) {
		Function function = functionDto.factoryFunction();
		function.setId(id);
		String updata = functionMethods.updata(function);		
		return ResponseEntity.status(HttpStatus.OK).body(updata);
	} 
	
	@ApiOperation("delete by id")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ok"),
		@ApiResponse(code = 404, message = "Not find")
	})
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/delete-by-id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable UUID id) {
		String deleteById = functionMethods.deleteById(id);		
		return ResponseEntity.status(HttpStatus.OK).body(deleteById);
	} 
}

