package com.exemple.backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.backend.dto.FunctionDto;
import com.exemple.backend.entity.Function;
import com.exemple.backend.face.FunctionFace;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/functions")
public class FunctionController {
	@Autowired
	private FunctionFace functionFace;
	
	@ApiOperation("save")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Created"),
		@ApiResponse(code = 400, message = "Bad request")
	})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody FunctionDto functionDto) {
		try {
			Function function = new Function();
			BeanUtils.copyProperties(functionDto, function);
			String create = functionFace.save(function);
			return ResponseEntity.status(HttpStatus.CREATED).body(create);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}	
	}
	
	@ApiOperation("list")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ok")
	})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/list")
	public ResponseEntity<List<Function>> list() {
		List<Function> functions = functionFace.list();
		return ResponseEntity.status(HttpStatus.OK).body(functions);
	}
	
	
	@ApiOperation("find by id")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ok"),
		@ApiResponse(code = 404, message = "Not find")
	})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/find-by-id/{id}")
	public ResponseEntity<?> findById(@PathVariable UUID id) {
		Function findById = functionFace.findById(id);
		if (findById == null) 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("function not found");
		else 
			return ResponseEntity.status(HttpStatus.OK).body(findById);
	}
	
	@ApiOperation("find by name")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ok"),
		@ApiResponse(code = 404, message = "Not find")
	})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/find-by-name/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name) {
		Function findByFunction = functionFace.findByName(name);
		if (findByFunction == null) 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("function not found");
		else 
			return ResponseEntity.status(HttpStatus.OK).body(findByFunction);
	}
	
	@ApiOperation("update")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ok"),
		@ApiResponse(code = 404, message = "Not find")
	})
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable UUID id, @RequestBody FunctionDto functionDto) {
		try {
			Function function = new Function();
			BeanUtils.copyProperties(functionDto, function);
			function.setId(id);			
			String updata = functionFace.updata(function);
			if (updata.equals("function not found")) 
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updata);			
			return ResponseEntity.status(HttpStatus.OK).body(updata);
		} catch (Exception e) { 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	} 
	
	@ApiOperation("delete by id")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ok"),
		@ApiResponse(code = 404, message = "Not find")
	})
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/delete-by-id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable UUID id) {
		String deleteById = functionFace.deleteById(id);
		if (deleteById.equals("function not found")) 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(deleteById);		
		return ResponseEntity.status(HttpStatus.OK).body(deleteById);
	} 
}
