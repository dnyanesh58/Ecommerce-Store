package com.epstore.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.epstore.DTO.CustomerLoginRespDTO;
import com.epstore.DTO.CustomerRegisterDTO;
import com.epstore.DTO.loginRequestDTO;
import com.epstore.custom_exceptions.ResourceNotFoundException;
import com.epstore.entities.Customer;
import com.epstore.repository.CustomerRepo;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService
{

	@Autowired
	private CustomerRepo dao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder passEncode;
	
	@Override
	public String registerCustomer(CustomerRegisterDTO dto) 
	{
		if (dao.existsByEmail(dto.getEmail())) 
		{
			throw new RuntimeException("Email Already Exists");
		}
		Customer newCust = new Customer();
		newCust.setFirstName(dto.getFirstName());
		newCust.setLastName(dto.getLastName());
		newCust.setEmail(dto.getEmail());
		newCust.setPassword(passEncode.encode(dto.getPassword()));
		newCust.setMobileNo(dto.getMobileNo());
		newCust.setGender(dto.getGender());
		newCust.setCreatedOn(new Date());
		dao.save(newCust);
		return "New Customer Added With Id : "+newCust.getId();
	}

	@Override
	public List<Customer> getAllCustomers() 
	{
		return dao.findAll();
	}

	@Override
	public Customer findCustomerById(Long custId) 
	{
		return dao.findById(custId).orElseThrow(() -> new ResourceNotFoundException("Invalid Customer Id"));
	}

	@Override
	public CustomerLoginRespDTO validateCustomer(loginRequestDTO dto) 
	{
		Customer newCust = dao.findByEmail(dto.getEmail())
				.orElseThrow(() -> new ResourceNotFoundException("Bad Credentials !!!!!"));
		if (passEncode.matches(dto.getPassword(),newCust.getPassword())) 
		{
			return mapper.map(newCust, CustomerLoginRespDTO.class);
		}
		throw new ResourceNotFoundException("Bad Credentials !!!!!");
	}

	@Override
	public Customer updateCustomerDetails(Customer existCustomer) 
	{
		if (dao.existsById(existCustomer.getId()))
		{
			return dao.save(existCustomer);
		}
		throw new ResourceNotFoundException("Invalid Customer Id !!!!!");
	}

	@Override
	public String removeCustomer(Long custId) 
	{
		if (dao.existsById(custId)) 
		{
			dao.deleteById(custId);
			return "Customer deleted with Id : "+custId;
		}
		return "Deletion Failed : Invalid Emp Id !!!!!!!!!!!";
	}
}
