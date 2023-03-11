package com.epstore.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epstore.DTO.AddressGetByIdDTO;
import com.epstore.DTO.AddressRegisterDTO;
import com.epstore.DTO.AddressUpdateDTO;
import com.epstore.custom_exceptions.ResourceNotFoundException;
import com.epstore.entities.Address;
import com.epstore.entities.Customer;
import com.epstore.repository.AddressRepo;


@Service
@Transactional
public class AddressServiceImpl implements AddressService
{

	@Autowired
	private AddressRepo dao;
	
	@Autowired
	private CustomerService custService;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String saveAddress(AddressRegisterDTO dto) 
	{
		Address address = new Address();
		address.setCity(dto.getCity());
		address.setStreet(dto.getStreet());
		address.setZipCode(dto.getZipCode());
		address.setCountry(dto.getCountry());
		address.setCustomerAddress(dto.getCustomerAddress());
		dao.save(address);
		return "New Address Added To Customer With Id : "+address.getCustomerAddress().getId();
	}

	@Override
	public Address updateAddress(AddressUpdateDTO existAddress)
	{
		if (dao.existsById(existAddress.getId())) 
		{
			Address addr = mapper.map(existAddress, Address.class);
			return dao.save(addr);	
		}
		throw new ResourceNotFoundException("Invalid Admin Id !!!!!");
	}

	@Override
	public String removeAddressById(Long Id) 
	{
		if (dao.existsById(Id)) 
		{
			dao.deleteById(Id);
			return "Address deleted with Id : "+Id;
		}
		return "Deletion Failed : Invalid Address Id !!!!!!!!!!!";
	}

	@Override
	public AddressGetByIdDTO findAddressById(Long addrId) 
	{
		Address addr = dao.findById(addrId).orElseThrow();
		AddressGetByIdDTO dto = mapper.map(addr, AddressGetByIdDTO.class);
		dto.setCustId(addr.getId());
		return dto;
	}

	  @Override public List<Address> findAllBycustomerAddress(Long custId) 
	  { 
		  Customer cust = custService.findCustomerById(custId);
		  return dao.findAllBycustomerAddress(cust); 
	  }
}
