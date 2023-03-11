package com.epstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epstore.entities.Categories;
import com.epstore.entities.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long>
{
	Optional<Products> findById(Long Id);
	
	List<Products> findProductsByProductCategory(Long Id);
	
	boolean existsProductsById(Long Id);
	
	//boolean existsProductsByTitle(Long Id);
	
	String deleteProductsById(Long Id);

//	List<Products> findAll(Optional<Categories> category);

	List<Products> findAllByproductCategory(Categories category);
	
	//String deleteProductsByTitle(Long Id);
}
