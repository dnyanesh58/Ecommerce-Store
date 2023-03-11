package com.epstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epstore.entities.Address;
import com.epstore.entities.Customer;

public interface AddressRepo extends JpaRepository<Address, Long>
{
	  List<Address> findAllBycustomerAddress(Customer customer);
	  
	  Optional<Address> findById(Long Id);
	  
	  boolean existsById(Long Id);
	 
	 void deleteById(Long Id);
}
