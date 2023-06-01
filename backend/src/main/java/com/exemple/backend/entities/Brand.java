package com.exemple.backend.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.exemple.backend.dtos.BrandDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"products"})
@EqualsAndHashCode(exclude = {"products"})
@Entity(name = "brand")
@JsonIgnoreProperties({"products"})
public class Brand {
	@Id
	@Column(nullable = false, length = 50)
	private String id;
	@Column(nullable = false, unique = true, length = 50)
	private String name;
	@OneToMany(mappedBy = "brand")
	private List<Product> products;
	
	public BrandDto factoryBrand() {
		BrandDto dto = new BrandDto();
		dto.setId(id);
		dto.setName(name);
		return dto;
	}
}
