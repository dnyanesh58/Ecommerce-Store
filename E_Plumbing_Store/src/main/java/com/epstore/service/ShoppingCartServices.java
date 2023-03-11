package com.epstore.service;

import java.util.List;

import com.epstore.DTO.AddToShoppingCartDTO;
import com.epstore.DTO.ShoppingCartDTO;
import com.epstore.entities.Customer;
import com.epstore.entities.ShoppingCart;

public interface ShoppingCartServices
{
	ShoppingCart addToCart(AddToShoppingCartDTO addedProduct, Long custId);
	
	ShoppingCartDTO listCartItems(Long custId);
	
	String deleteCartItem(Long cartItemId,Long custId);
	
	String deleteAllCartItems(Long custId);
}
