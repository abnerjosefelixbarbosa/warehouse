package com.exemple.backend.entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "brand")
@JsonIgnoreProperties({"products"})
public class Brand {
	@Id
	@GeneratedValue
	private UUID id;
	@Column(nullable = false, unique = true, length = 50)
	private String name;
	@OneToMany(mappedBy = "brand")
	private List<Product> products;
}
