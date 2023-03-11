package com.epstore.DTO;

import com.epstore.entities.Products;
import com.epstore.entities.ShoppingCart;

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
public class CartItemDTO 
{
	private Long id;
	
	private int quantity;
	
	private Products product;
	
	public CartItemDTO(ShoppingCart cart)
	{
		this.id = cart.getId();
		this.quantity = cart.getQuantity();
		this.product = cart.getCartProduct();
	}
}
