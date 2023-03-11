package com.epstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epstore.DTO.AddToShoppingCartDTO;
import com.epstore.service.ShoppingCartServices;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController 
{
	
	@Autowired
	private ShoppingCartServices cartService;
	
	public ShoppingCartController()
	{
		System.out.println("In Ctor of : "+getClass());
	}
	
	@PostMapping("/{custId}")
	public ResponseEntity<?> addProductToCart(@RequestBody AddToShoppingCartDTO addProduct
			,@PathVariable Long custId)
	{
		return ResponseEntity.ok(cartService.addToCart(addProduct, custId));
	}
	
	@GetMapping("/{custId}")
	public ResponseEntity<?> listAllCartItems(@PathVariable Long custId)
	{
		return ResponseEntity.ok(cartService.listCartItems(custId));
	}
	
	@DeleteMapping("/{cartItemId}/cust/{custId}")
	public ResponseEntity<?> deleteCartItem(@PathVariable Long cartItemId, Long custId)
	{
		return ResponseEntity.ok(cartService.deleteCartItem(cartItemId, custId));
	}
	
	@DeleteMapping()
	public ResponseEntity<?> deleteAllCartItems(@PathVariable Long custId)
	{
		return ResponseEntity.ok(cartService.deleteAllCartItems(custId));
	}
}
