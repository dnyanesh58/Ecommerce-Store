package com.epstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Admin extends BaseEntity
{
	@NotBlank(message = "Name cannot be blank")
	@Column(length = 30)
	private String name;

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
}
