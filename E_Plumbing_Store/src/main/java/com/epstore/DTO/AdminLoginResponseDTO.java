package com.epstore.DTO;

import java.util.List;

import com.epstore.entities.Address;

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
public class AdminLoginResponseDTO
{
	private String name;

	private String email;
}
