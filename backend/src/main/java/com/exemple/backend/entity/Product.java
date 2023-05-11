package com.exemple.backend.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"employee", "address"})
@Entity(name = "product")
public class Product {
	@Id
	@GeneratedValue
	private UUID id;	
	@Column(nullable = false, length = 100)
	private String product;	
	@Column(nullable = false, length = 50)
	private String brand;	
	@Column(nullable = false)
	private Integer size;	
	@JsonFormat(pattern = "yyyy-MM-dd@HH:mmZ")
	@Column(nullable = false)
	private Date date;	
	@Column(nullable = false)
	private Double Weight;	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "matriculation", nullable = false)
	private Employee employee;	
}
