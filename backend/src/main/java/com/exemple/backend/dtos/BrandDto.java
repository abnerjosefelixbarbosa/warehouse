package com.exemple.backend.dtos;

import com.exemple.backend.entities.Brand;

import lombok.Data;

@Data
public class BrandDto {
	private String id;
	private String name;
	
	public Brand FactoryBrand() {
		Brand brand = new Brand();
		brand.setId(id);
		brand.setName(name);
		return brand;
	}
}
