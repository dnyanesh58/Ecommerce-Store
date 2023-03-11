package com.epstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epstore.entities.Categories;

public interface CategoriesRepo extends JpaRepository<Categories, Long>
{
	Optional<Categories> findCategoriesById(Long Id);
	
	boolean existsById(Long Id);
	
	void deleteById(Long Id);
}
