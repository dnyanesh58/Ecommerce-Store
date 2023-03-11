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

import com.epstore.DTO.AdminRegisterRequest;
import com.epstore.DTO.loginRequestDTO;
import com.epstore.entities.Admin;
import com.epstore.service.AdminService;
import com.epstore.service.CustomerService;

@RestController
@RequestMapping("/admin")
@Validated
public class AdminController
{

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerService custService;

	public AdminController()
	{
		System.out.println("In ctor of : "+getClass());
	}
	
	@GetMapping("/customers")
	public ResponseEntity<?> getAllCustomer()
	{
		System.out.println("In get All "+getClass());
		return ResponseEntity.ok(custService.getAllCustomers());
	}

	@PostMapping("/login")
	public ResponseEntity<?> validateAdmin(@RequestBody @Valid loginRequestDTO dto)
	{
		System.out.println("In login "+getClass());
		return ResponseEntity.ok(adminService.validateAdmin(dto));
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerAdmin(@RequestBody @Valid AdminRegisterRequest dto)
	{
		System.out.println("In register "+getClass());
		return ResponseEntity.ok(adminService.addAdmin(dto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAdminById(@PathVariable Long id)
	{
		System.out.println("In getById "+getClass());
		return ResponseEntity.ok(adminService.getAdminDetailsById(id));
	}
	
	@PutMapping
	public ResponseEntity<?> updateAdmin(@RequestBody Admin existAdmin)
	{
		System.out.println("In update "+getClass());
		return ResponseEntity.ok(adminService.updateAdminDetails(existAdmin));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAdminById(@PathVariable Long id)
	{
		System.out.println("In delete : "+getClass());
		return ResponseEntity.ok(adminService.removeAdmin(id));
	}
}
