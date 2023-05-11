package com.exemple.backend.dto;

import java.util.Date;
import java.util.UUID;

import com.exemple.backend.entity.Address;
import com.exemple.backend.entity.Employee;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"employee", "address"})
public class ProductDto {
	private UUID id;	
	private String product;	
	private String brand;	
	private Integer size;	
	private Date date;	
	private Double Weight;	
	private Address address;
	private Employee employee;	
}
