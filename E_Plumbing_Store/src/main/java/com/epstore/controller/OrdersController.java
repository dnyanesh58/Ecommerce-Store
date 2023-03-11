package com.epstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epstore.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController 
{
	
	@Autowired
	private OrdersService orderService;
	
	public OrdersController()
	{
		System.out.println("In Ctor Of : "+getClass());
	}
	
	@PostMapping("/{custId}/cart/{cartId}")
	public ResponseEntity<?> processOrder(@PathVariable Long custId)
	{
		return ResponseEntity.ok(orderService.saveOrder(custId));
	}
	
	@GetMapping("/{custId}")
	public ResponseEntity<?> getAllOrders(@PathVariable Long custId)
	{
		return ResponseEntity.ok(orderService.getAllOrderByCustomer(custId));
	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<?> removeOrder(@PathVariable Long orderId)
	{
		return ResponseEntity.ok(orderService.removeOrderById(orderId));
	}
}
