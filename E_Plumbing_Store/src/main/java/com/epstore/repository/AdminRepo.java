package com.epstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epstore.entities.Admin;


@Repository
public interface AdminRepo extends JpaRepository<Admin, Long>
{
	Optional<Admin> findByEmailAndPassword(String email,String paasword);

	@Override
	Optional<Admin> findById(Long Id);
	
	Optional<Admin> findByEmail(String email);

	Boolean existsByEmail(String email);

	boolean existsById(Long Id);

	@Override
	void deleteById(Long Id);
}
