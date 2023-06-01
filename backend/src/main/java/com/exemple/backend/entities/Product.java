package com.exemple.backend.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.exemple.backend.dtos.ProductDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity(name = "product")
public class Product {
	@Id
	@Column(nullable = false, length = 50)
	private String id;	
	@Column(nullable = false, length = 100)
	private String name;	
	@Column(nullable = false, length = 20)
	private String addressZipCode;
	@Column(nullable = false)
	private Integer addressNumber;
	@Column(nullable = false, length = 50)
	private String addressName;
	@Column(nullable = false, length = 30)
	private String addressNeighborhood;
	@Column(nullable = false, length = 30)
	private String addressCity;
	@Column(nullable = false, length = 30)
	private String addressState;
	@JsonFormat(pattern = "yyyy-MM-dd@HH:mmZ")
	@Column(nullable = false)
	private Date dateTime;	
	@Column(nullable = false)
	private Double Weight;	
	@ManyToOne
	@JoinColumn(name = "employee_matriculation", nullable = false)
	private Employee employee;
	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private Brand brand;
	
	public ProductDto factoryProductDto() {
		ProductDto dto = new ProductDto();
		dto.setId(id);
		dto.setName(name);
		dto.setAddressZipCode(addressZipCode);
		dto.setAddressNumber(addressNumber);
		dto.setAddressName(addressName);
		dto.setAddressNeighborhood(addressNeighborhood);
		dto.setAddressCity(addressCity);
		dto.setAddressState(addressState);
		dto.setDateTime(dateTime);
		dto.setWeight(Weight);
		dto.setEmployee(employee);
		dto.setBrand(brand);
		return dto;
	}
}
