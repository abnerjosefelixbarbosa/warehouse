package com.exemple.backend.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"employe", "address"})
@Entity(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String brand;
	@Column(nullable = false)
	private Integer size;
	@JsonFormat(pattern = "yyyy-MM-dd@HH:mmZ")
	@Column(nullable = false)
	private Date dateTime;
	@Column(nullable = false)
	private Double Weight;
	@Column(name = "employe_id", nullable = false)
	private UUID  employeId;
	@Column(name = "address_id", nullable = false)
	private UUID addressId;
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(optional = false)
	@JoinColumn(name = "employe_id", nullable = false, insertable = false, updatable = false)
	private Employe employe;
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(optional = false)
	@JoinColumn(name = "address_id", nullable = false, insertable = false, updatable = false)
	private Address address;
}
