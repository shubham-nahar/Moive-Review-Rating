package com.flixme.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	@Column(unique = true)

	private String email;

	private String phone;

	private String password;

	private String city;

	private String pincode;

	private String country;

	private Double Balance = 0.0;

	private String role = "customer";

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Review> review;

}
