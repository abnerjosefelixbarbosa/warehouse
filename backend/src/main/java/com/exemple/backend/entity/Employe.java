package com.exemple.backend.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
}
