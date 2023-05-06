package com.exemple.backend.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"position","products"})
@Entity(name = "employe")
public class Employe {
	@Id
	private Long matriculation;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Double salary;
	@Column(name = "position_id", nullable = false)
	private UUID positionId;
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(optional = false)
	@JoinColumn(name = "position_id", nullable = false, insertable = false, updatable = false)
	private Position position;
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "employe")
	private List<Product> products;
}
