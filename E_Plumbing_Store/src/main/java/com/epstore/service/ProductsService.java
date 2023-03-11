package com.epstore.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.epstore.DTO.ProductAddDTO;
import com.epstore.entities.Products;

public interface ProductsService
{
	List<Products> getAllProducts();
	
	List<Products> getAllByCategoriesId(Long Id);

	String addNewProduct(ProductAddDTO newProduct);

	String removeProduct(Long productId);

	Products updateProduct(Products existProduct);

	Products getProductById(Long productId);
}
