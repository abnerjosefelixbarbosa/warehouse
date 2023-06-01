package com.exemple.backend.dtos;

import com.exemple.backend.entities.Function;

import lombok.Data;

@Data
public class FunctionDto {
	private String id;
	private String name;
	
	public Function factoryFunction() {
		Function function = new Function();
		function.setId(id);
		function.setName(name);
		return function;
	}
}
