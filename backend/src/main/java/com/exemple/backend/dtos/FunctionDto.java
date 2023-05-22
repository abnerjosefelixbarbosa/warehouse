package com.exemple.backend.dtos;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FunctionDto {
	private UUID id;
	private String name;
}
