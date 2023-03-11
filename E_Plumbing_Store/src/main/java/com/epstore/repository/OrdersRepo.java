package com.epstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.epstore.entities.Customer;
import com.epstore.entities.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Long>
{
	List<Orders> findByCustomer(Customer cust);
	
	/*
	 * @Modifying
	 * 
	 * @Query(value
	 * ="Insert into orders select * from shopping_cart where customer_id = ?1",
	 * nativeQuery = true) int addToOrder(Long id);
	 */
}
