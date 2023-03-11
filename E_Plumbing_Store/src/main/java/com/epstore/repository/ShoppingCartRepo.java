package com.epstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epstore.DTO.CartItemDTO;
import com.epstore.entities.Customer;
import com.epstore.entities.ShoppingCart;

public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long>
{
	Optional<ShoppingCart> findCartById(Long id);
	
	List<ShoppingCart> findAllBycustomer(Customer customer);
}
