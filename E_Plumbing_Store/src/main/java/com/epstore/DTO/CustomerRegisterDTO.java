package com.epstore.DTO;

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
public class CustomerRegisterDTO 
{
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String mobileNo;
	
	private String gender;
}
