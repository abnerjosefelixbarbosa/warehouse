package com.exemple.backend.dtos;

import java.util.UUID;

import com.exemple.backend.entities.Function;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"name"})
public class FunctionDto {
	private UUID id;
	private String name;
	
	public Function factoryFunction() {
		Function function = new Function();
		function.setId(id);
		function.setName(name);
		return function;
	}
}
