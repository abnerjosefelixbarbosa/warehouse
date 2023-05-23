package com.exemple.backend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<String> save(@RequestBody EmployeeDto employeeDto) {
		try {
			Employee employee = new Employee();
			BeanUtils.copyProperties(employeeDto, employee);
			String save = employeeMethods.save(employee);
			return ResponseEntity.status(HttpStatus.CREATED).body(save);
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
	public ResponseEntity<String> list() {
			//String save = employeeMethods.save(employee);
			return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
