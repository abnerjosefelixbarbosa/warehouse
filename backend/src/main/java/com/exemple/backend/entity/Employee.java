package com.exemple.backend.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"function","products"})
@Entity(name = "employee")
public class Employee {
	@Id
	@Column(nullable = false, length = 10)
	private Long matriculation;	
	@Column(nullable = false, length = 100)
	private String employee;	
	@Column(nullable = false)
	private Double salary;		
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "function_id", nullable = false)
	private Function function;	
	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
	private List<Product> products;
}
