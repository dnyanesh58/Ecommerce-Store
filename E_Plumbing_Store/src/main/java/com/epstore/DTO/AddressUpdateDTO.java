package com.epstore.DTO;

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
public class AddressUpdateDTO 
{
	
	private Long id;
	
	private String city;
	
	private String street;
	
	private String zipCode;
	
	private String country;
}
