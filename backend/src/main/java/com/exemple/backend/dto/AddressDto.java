package com.exemple.backend.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressDto {
	private UUID id;	
	private String zipCode;	
	private Integer number;
	private String address;	
	private String neighborhood;	
	private String city;	
	private String state;	
}
