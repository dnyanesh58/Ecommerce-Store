package com.epstore.service;

import java.util.List;

import com.epstore.entities.Customer;
import com.epstore.entities.Orders;

public interface OrdersService
{
	Orders saveOrder(Long custId);

	List<Orders> getAllOrderByCustomer(Long custId);

	String removeOrderById(Long orderId);
}
