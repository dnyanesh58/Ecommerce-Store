package com.epstore.DTO;

import java.util.List;

import com.epstore.entities.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerLoginRespDTO 
{
	private String firstName;

	private String lastName;

	private String email;

	private String mobileNo;

	private String gender;

	private List<Address> Addresses;
}
