package com.epstore.entities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Customer extends BaseEntity
{
	@NotBlank(message = "firstname cannot be blank")
	@Column(length = 30)
	private String firstName;

	@NotBlank(message = "lastname cannot be blank")
	@Column(length = 30)
	private String lastName;

	@Email
	@Column(length = 30,unique = true)
	private String email;

	@NotBlank(message = ""
			+ "At least 8 chars\r\n"
			+ "\r\n"
			+ "Contains at least one digit\r\n"
			+ "\r\n"
			+ "Contains at least one lower alpha char and one upper alpha char\r\n"
			+ "\r\n"
			+ "Contains at least one char within a set of special chars (@#%$^ etc.)\r\n"
			+ "\r\n"
			+ "Does not contain space, tab, etc.")
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
	@Column(length = 300)
	private String password;

	@NotBlank(message = "Mobile no cannot be blank")
	@Column(length = 10,nullable = true)
	private String mobileNo;

	@NotBlank(message = "Gender cannot be blank")
	@Column(length = 10,nullable = true)
	private String gender;

	@CreatedDate
	private Date createdOn;

	@JsonIgnore
	@OneToMany(mappedBy = "customerAddress",cascade = CascadeType.ALL,orphanRemoval = true,
			fetch = FetchType.LAZY)
	private List<Address> Addresses = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Orders> custOrders = new ArrayList<Orders>();
}
