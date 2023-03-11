package com.epstore.service;

import java.util.List;

import com.epstore.DTO.AddressGetByIdDTO;
import com.epstore.DTO.AddressRegisterDTO;
import com.epstore.DTO.AddressUpdateDTO;
import com.epstore.entities.Address;

public interface AddressService
{
	String saveAddress(AddressRegisterDTO dto);

	Address updateAddress(AddressUpdateDTO dto);

	String removeAddressById(Long Id);

	AddressGetByIdDTO findAddressById(Long addrId);
	
	List<Address> findAllBycustomerAddress(Long custId);
}
