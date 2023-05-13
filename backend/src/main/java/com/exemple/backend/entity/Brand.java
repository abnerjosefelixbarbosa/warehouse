package com.exemple.backend.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"product"})
@Entity(name = "brand")
public class Brand {
	@Id
	@GeneratedValue
	private UUID id;
	@Column(nullable = false, unique = true, length = 50)
	private String brand;	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
}
