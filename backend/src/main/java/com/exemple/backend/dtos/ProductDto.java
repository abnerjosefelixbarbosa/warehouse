package com.exemple.backend.dtos;

import java.util.Date;

import com.exemple.backend.entities.Brand;
import com.exemple.backend.entities.Employee;
import com.exemple.backend.entities.Product;

import lombok.Data;

@Data
public class ProductDto {
	private String id;	
	private String name;	
	private String addressZipCode;
	private Integer addressNumber;
	private String addressName;
	private String addressNeighborhood;
	private String addressCity;
	private String addressState;
	private Date dateTime;	
	private Double Weight;	
	private Employee employee;
	private Brand brand;
	
	public Product factoryProduct() {
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setAddressZipCode(addressZipCode);
		product.setAddressNumber(addressNumber);
		product.setAddressName(addressName);
		product.setAddressNeighborhood(addressNeighborhood);
		product.setAddressCity(addressCity);
		product.setAddressState(addressState);
		product.setDateTime(dateTime);
		product.setWeight(Weight);
		product.setEmployee(employee);
		product.setBrand(brand);
		return product;
	}
}
