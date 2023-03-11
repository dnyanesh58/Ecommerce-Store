package com.epstore.DTO;

import java.util.List;

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
public class ShoppingCartDTO 
{
	private List<CartItemDTO> cartItems;
	
	private double totalPrice;
}
