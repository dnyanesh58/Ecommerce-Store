package com.epstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epstore.entities.Categories;
import com.epstore.service.CategoriesService;

@RestController
@RequestMapping("/categories")
public class CategoriesController 
{
	
	@Autowired
	private CategoriesService catService;
	
	public CategoriesController()
	{
		System.out.println("In Ctor of : "+getClass());
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCategories()
	{
		return ResponseEntity.ok(catService.getAllCategories());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Long id)
	{
		return ResponseEntity.ok(catService.getCategoryById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> saveNewCategory(@RequestBody Categories newCategory)
	{
		return ResponseEntity.ok(catService.addNewCategory(newCategory));
	}
	
	@PutMapping
	public ResponseEntity<?> updateCategory(@RequestBody Categories existCategories)
	{
		return ResponseEntity.ok(catService.updateCategory(existCategories));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeCategory(@PathVariable Long id)
	{
		return ResponseEntity.ok(catService.removeCategoryById(id));
	}
}
