package com.epstore.service;

import java.util.List;

import com.epstore.DTO.CustomerLoginRespDTO;
import com.epstore.DTO.CustomerRegisterDTO;
import com.epstore.DTO.loginRequestDTO;
import com.epstore.entities.Customer;

public interface CustomerService
{
	String registerCustomer(CustomerRegisterDTO dto);

	List<Customer> getAllCustomers();

	Customer findCustomerById(Long custId);

	CustomerLoginRespDTO validateCustomer(loginRequestDTO dto);

	Customer updateCustomerDetails(Customer existCustomer);

	String removeCustomer(Long custId);
}
