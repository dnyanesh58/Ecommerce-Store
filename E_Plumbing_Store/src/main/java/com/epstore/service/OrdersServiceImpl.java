package com.epstore.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epstore.DTO.CartItemDTO;
import com.epstore.DTO.ShoppingCartDTO;
import com.epstore.custom_exceptions.ResourceNotFoundException;
import com.epstore.entities.Customer;
import com.epstore.entities.Orders;
import com.epstore.entities.ShoppingCart;
import com.epstore.repository.OrdersRepo;
import com.epstore.repository.ShoppingCartRepo;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService
{
	
	@Autowired
	private OrdersRepo dao;
	
	@Autowired
	private ShoppingCartServices cartService;
	
	@Autowired
	private CustomerService custService;
	
	@Autowired 
	private ShoppingCartRepo cartDao;

	@Override
	public Orders saveOrder(Long custId) 
	{
		ShoppingCartDTO cartDTO = cartService.listCartItems(custId);
		Customer customer = custService.findCustomerById(custId);
		
		Orders order = new Orders();
		order.setCreatedOn(new Date());
		order.setCustomer(customer);
		order.setTotalPrice(cartDTO.getTotalPrice());
		dao.save(order);
		cartService.deleteAllCartItems(custId);
		return order;
	}

	@Override
	public List<Orders> getAllOrderByCustomer(Long custId) 
	{
		Customer customer = custService.findCustomerById(custId);
		return dao.findByCustomer(customer);
	}

	@Override
	public String removeOrderById(Long orderId) 
	{
		if (dao.existsById(orderId)) 
		{
			dao.deleteById(orderId);
			return "Order deleted with id : "+orderId;
		}
		throw new ResourceNotFoundException("Deletion Failed Invalid OrderId "+orderId);
	}
}
