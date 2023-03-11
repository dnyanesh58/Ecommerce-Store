package com.epstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epstore.DTO.CustomerRegisterDTO;
import com.epstore.DTO.loginRequestDTO;
import com.epstore.entities.Customer;
import com.epstore.service.CustomerService;
import com.epstore.service.ShoppingCartServices;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController 
{	
	
	@Autowired
	private CustomerService custService;
	
	@Autowired
	private ShoppingCartServices cartService;
	
	public CustomerController()
	{
		System.out.println("In ctor of : "+getClass());
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> validateCustomer(@RequestBody @Valid loginRequestDTO dto)
	{
		System.out.println("In login "+getClass());
		return ResponseEntity.ok(custService.validateCustomer(dto));
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerCustomer(@RequestBody @Valid CustomerRegisterDTO dto)
	{
		System.out.println("In register "+getClass());
		return ResponseEntity.ok(custService.registerCustomer(dto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable Long id)
	{
		System.out.println("In get by id "+getClass());
		return ResponseEntity.ok(custService.findCustomerById(id));
	}
	
	@PutMapping
	public ResponseEntity<?> updateCustomer(@RequestBody Customer existCust)
	{
		System.out.println("In update "+getClass());
		return ResponseEntity.ok(custService.updateCustomerDetails(existCust));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id)
	{
		System.out.println("In delete "+getClass());
		return ResponseEntity.ok(custService.removeCustomer(id));
	}
}
