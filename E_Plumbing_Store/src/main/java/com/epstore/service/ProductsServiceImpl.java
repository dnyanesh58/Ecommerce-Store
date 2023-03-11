package com.epstore.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epstore.DTO.ProductAddDTO;
import com.epstore.custom_exceptions.ResourceNotFoundException;
import com.epstore.entities.Categories;
import com.epstore.entities.Products;
import com.epstore.repository.CategoriesRepo;
import com.epstore.repository.ProductsRepo;

@Service
@Transactional
public class ProductsServiceImpl implements ProductsService
{

	@Autowired
	private ProductsRepo dao;
	
	@Autowired
	private CategoriesService catService;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Products> getAllProducts() 
	{
		return dao.findAll();
	}

	@Override
	public String addNewProduct(ProductAddDTO dto) 
	{
		Products product = new Products();
		product.setTitle(dto.getTitle());
		product.setImage(dto.getImage());
		product.setUnitPrice(dto.getUnitPrice());
		product.setAvailable(dto.isAvailable());
		product.setUnitStock(dto.getUnitStock());
		product.setProductCategory(dto.getProductCategory());
		dao.save(product);
		return "New Product is added with Id : "+product.getId();
	}

	@Override
	public String removeProduct(Long productId) 
	{
		if (dao.existsById(productId)) 
		{
			dao.deleteById(productId);
			return "Product deleted with productId : "+productId;
		}
		return "Deletion Failed Invalid Id !!!!!";
	}

	@Override
	public Products updateProduct(Products existProduct) 
	{
		if (dao.existsById(existProduct.getId())) 
		{
			return dao.save(existProduct);
		}
		throw new ResourceNotFoundException("Invalid Product Id : Updation Failed!!!!!!!!");
	}

	@Override
	public Products getProductById(Long productId) 
	{
		return dao.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Invalid Product ID !!!!!"));
	}

	@Override
	public List<Products> getAllByCategoriesId(Long Id) 
	{
		Categories category = catService.getCategoryById(Id);
		return dao.findAllByproductCategory(category);
	}

}
