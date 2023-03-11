package com.epstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epstore.custom_exceptions.ResourceNotFoundException;
import com.epstore.entities.Categories;
import com.epstore.repository.CategoriesRepo;

@Service
@Transactional
public class CategoriesServiceImpl implements CategoriesService
{

	@Autowired
	private CategoriesRepo dao;
	
	@Override
	public List<Categories> getAllCategories() 
	{
		return dao.findAll();
	}

	@Override
	public Categories getCategoryById(Long catId) 
	{
		return dao.findCategoriesById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Product ID !!!!!"));
	}

	@Override
	public Categories addNewCategory(Categories newCategory) 
	{
		return dao.save(newCategory);
	}

	@Override
	public Categories updateCategory(Categories existCategory) 
	{
		if (dao.existsById(existCategory.getId())) 
		{
			return dao.save(existCategory);
		}
		throw new ResourceNotFoundException("Invalid Category Id : Updation Failed!!!!!!!!");
	}

	@Override
	public String removeCategoryById(Long catId) 
	{
		if (dao.existsById(catId)) 
		{
			dao.deleteById(catId);
			return "Category deleted with Id : "+catId;
		}
		return "Deletion Failed Invalid Id !!!!!";
	}

}
