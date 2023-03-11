package com.epstore.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epstore.DTO.AddToShoppingCartDTO;
import com.epstore.DTO.CartItemDTO;
import com.epstore.DTO.ShoppingCartDTO;
import com.epstore.custom_exceptions.ResourceNotFoundException;
import com.epstore.entities.Customer;
import com.epstore.entities.Products;
import com.epstore.entities.ShoppingCart;
import com.epstore.repository.ShoppingCartRepo;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartServices
{

	@Autowired 
	private ProductsService prodService;
	
	@Autowired
	private ShoppingCartRepo dao;
	
	@Autowired
	private CustomerService custService;
	
	@Override
	public ShoppingCart addToCart(AddToShoppingCartDTO addedProduct, Long custId) 
	{
		Products product = prodService.getProductById(addedProduct.getProductId());
		
		Customer customer = custService.findCustomerById(custId);
		
		ShoppingCart cart = new ShoppingCart();
		cart.setCartProduct(product);
		cart.setCustomer(customer);
		cart.setQuantity(addedProduct.getQuantity());
		cart.setCreatedOn(new Date());
		return dao.save(cart);
	}

	@Override
	public ShoppingCartDTO listCartItems(Long custId) 
	{
		Customer customer = custService.findCustomerById(custId);
		final List<ShoppingCart> cartList = dao.findAllBycustomer(customer);
		
		List<CartItemDTO> cartItems = new ArrayList<CartItemDTO>();
		double totalCost = 0;
		
		for (ShoppingCart cart : cartList) 
		{
			CartItemDTO cartItemsDTO = new CartItemDTO(cart);
			totalCost += cartItemsDTO.getQuantity() * cartItemsDTO.getProduct().getUnitPrice();
			cartItems.add(cartItemsDTO);
		}
		
		ShoppingCartDTO cartDTO = new ShoppingCartDTO();
		cartDTO.setCartItems(cartItems);
		cartDTO.setTotalPrice(totalCost);
		return cartDTO;
	}

	@Override
	public String deleteCartItem(Long cartItemId, Long custId) 
	{
		Customer cust = custService.findCustomerById(custId);
		
		ShoppingCart cart = dao.findCartById(cartItemId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid CartId !!!!!"));
		if (cart.getCustomer() != cust) 
			throw new ResourceNotFoundException("CartItem not belong to customer : "+cartItemId);
		dao.deleteById(cartItemId);
		return "CartItem Deleted "+cartItemId;
	}

	@Override
	public String deleteAllCartItems(Long custId) 
	{
		Customer customer = custService.findCustomerById(custId);
		List<ShoppingCart> cartList = dao.findAllBycustomer(customer);
		
		dao.deleteAll(cartList);
		return "All CartItems Deleted";
	}
}
