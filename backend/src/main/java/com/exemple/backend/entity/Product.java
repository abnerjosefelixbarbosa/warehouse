package com.exemple.backend.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "product")
public class Product {
	@Id
	@GeneratedValue
	private UUID id;	
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
}
