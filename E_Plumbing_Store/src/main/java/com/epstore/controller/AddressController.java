package com.epstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epstore.DTO.AddressRegisterDTO;
import com.epstore.DTO.AddressUpdateDTO;
import com.epstore.entities.Address;
import com.epstore.entities.Customer;
import com.epstore.service.AddressService;
import com.epstore.service.CustomerService;

@RestController
@RequestMapping("/customer/address")
@Validated
public class AddressController 
{
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private CustomerService custService;
	
	public AddressController()
	{
		System.out.println("In ctor of : "+getClass());
	}
	
	  @GetMapping("/custID/{id}") 
	  public ResponseEntity<?> getAllAdressesByCustomerId(@PathVariable Long id) 
	  {
		  return ResponseEntity.ok(addressService.findAllBycustomerAddress(id));
	  }
	 
	@PostMapping("/{custid}")
	public ResponseEntity<?> saveNewAddress(@RequestBody @Valid AddressRegisterDTO dto
			,@PathVariable Long custid)
	{
		Customer customer = custService.findCustomerById(custid);
		dto.setCustomerAddress(customer);
		return ResponseEntity.ok(addressService.saveAddress(dto));
	}
	
	@PatchMapping
	public ResponseEntity<?> updateAddress(@RequestBody AddressUpdateDTO existAddress)
	{
		return ResponseEntity.ok(addressService.updateAddress(existAddress));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAddressById(@PathVariable Long id)
	{
		return ResponseEntity.ok(addressService.findAddressById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable Long id)
	{
		return ResponseEntity.ok(addressService.removeAddressById(id));
	}
}
