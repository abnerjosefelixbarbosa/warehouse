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
	@Column(nullable = false, length = 20)
	private String postalCode;	
	@Column(nullable = false, length = 50)
	private String neighborhood;	
	@Column(nullable = false, length = 50)
	private String address;	
	@Column(nullable = false, length = 30)
	private String city;	
	@Column(nullable = false, length = 30)
	private String state;	
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "address")
	private List<Product> products;
}
