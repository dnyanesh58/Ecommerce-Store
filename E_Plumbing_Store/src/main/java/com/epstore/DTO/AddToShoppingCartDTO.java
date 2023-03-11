package com.epstore.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AddToShoppingCartDTO 
{
	private Long id;
	
	private Long productId;
	
	private int quantity;
}
