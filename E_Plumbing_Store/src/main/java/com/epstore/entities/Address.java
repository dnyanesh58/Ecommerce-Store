package com.epstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Address extends BaseEntity
{
	@NotBlank(message = "city can't be blank")
	@Column(length = 30)
	private String city;

	@NotBlank(message = "street can't be blank")
	@Column(length = 30)
	private String street;

	@NotBlank(message = "zipcode can't be blank")
	@Column(length = 10,nullable = true)
	private String zipCode;

	@NotBlank(message = "country can't be blank")
	@Column(length = 30,nullable = true)
	private String country;

	@NotNull(message = "customer_id can't be null")
	@ManyToOne
	@JoinColumn(name = "cust_id",updatable = false)
	private Customer customerAddress;
}
