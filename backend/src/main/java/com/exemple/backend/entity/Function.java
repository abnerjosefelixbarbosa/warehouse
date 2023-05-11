package com.exemple.backend.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"employees"})
@Entity(name = "function")
public class Function {
	@Id
	@GeneratedValue
	private UUID id;
	@Column(nullable = false, unique = true, length = 30)
	private String function;
	@JsonIgnore
	@OneToMany(mappedBy = "function", cascade = CascadeType.REMOVE)
	private List<Employee> employees;
}
