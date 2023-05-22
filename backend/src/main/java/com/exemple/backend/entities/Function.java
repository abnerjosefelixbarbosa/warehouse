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
@Entity(name = "function")
@JsonIgnoreProperties({"employees"})
public class Function {
	@Id
	@GeneratedValue
	private UUID id;
	@Column(nullable = false, unique = true, length = 30)
	private String name;
	@OneToMany(mappedBy = "function")
	private List<Employee> employees;
}