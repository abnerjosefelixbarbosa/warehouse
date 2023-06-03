package com.exemple.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.backend.dtos.EmployeeDto;
import com.exemple.backend.entities.Employee;
import com.exemple.backend.interfaces.EmployeeMethods;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeMethods employeeMethods;

	@ApiOperation("save")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Created"),
		@ApiResponse(code = 400, message = "Bad request")
	})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody EmployeeDto dto) {
		Employee employee = dto.factoryEmployee();
		String save = employeeMethods.save(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	
	@ApiOperation("list")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ok")
	})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/list")
	public ResponseEntity<List<Employee>> list() {
		List<Employee> list = employeeMethods.list();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@ApiOperation("find by matriculation")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ok"),
		@ApiResponse(code = 404, message = "Not found")
	})
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/find-by-matriculation")
	public ResponseEntity<Employee> findByMatriculation(@RequestBody EmployeeDto dto) {
		Employee findByMatriculation = employeeMethods.findByMatriculation(dto.getMatriculation());
		return ResponseEntity.status(HttpStatus.OK).body(findByMatriculation);
	}
	
	@ApiOperation("update")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ok"),
		@ApiResponse(code = 404, message = "Not found"),
		@ApiResponse(code = 400, message = "Bad request")
	})
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody EmployeeDto dto) {		
		Employee employee = dto.factoryEmployee();
		String update = employeeMethods.update(employee);
		return ResponseEntity.status(HttpStatus.OK).body(update);
	}
}
