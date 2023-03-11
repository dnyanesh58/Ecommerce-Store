package com.epstore.DTO;

import com.epstore.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddressRegisterDTO 
{
	private String city;
	
	private String street;
	
	private String zipCode;
	
	private String country;
	
	private Customer customerAddress;
}
