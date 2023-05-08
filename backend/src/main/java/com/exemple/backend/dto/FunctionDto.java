package com.exemple.backend.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FunctionDto {
	private UUID id;
	private String function;
}
