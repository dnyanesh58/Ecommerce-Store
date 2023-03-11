package com.epstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epstore.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>
{
	Optional<Customer> findByEmailAndPassword(String email,String paasword);
	
	Optional<Customer>  findByEmail(String email);

	@Override
	Optional<Customer> findById(Long Id);

	Boolean existsByEmail(String email);

	boolean existsById(Long Id);

	@Override
	void deleteById(Long Id);
}
