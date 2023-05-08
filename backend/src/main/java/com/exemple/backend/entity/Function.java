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
@ToString(exclude = {"employes"})
@Entity(name = "function")
public class Function {
	@Id
	@GeneratedValue
	private UUID id;
	@Column(nullable = false, length = 30)
	private String function;
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "function")
	private List<Employe> employes;
}
