package com.exemple.backend.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"products"})
@Entity(name = "address")
public class Address {
	@Id
	@GeneratedValue
	private UUID id;	
	@Column(nullable = false)
	private Integer number;	
	@Column(nullable = false)
	private String postalCode;	
	@Column(nullable = false)
	private String neighborhood;	
	@Column(nullable = false)
	private String address;	
	@Column(nullable = false)
	private String city;	
	@Column(nullable = false)
	private String state;	
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "address")
	private List<Product> products;
}
