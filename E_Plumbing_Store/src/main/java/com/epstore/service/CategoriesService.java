package com.epstore.service;

import java.util.List;

import com.epstore.entities.Categories;

public interface CategoriesService
{
	List<Categories> getAllCategories();

	Categories getCategoryById(Long catId);

	Categories addNewCategory(Categories newCategory);

	Categories updateCategory(Categories existCategory);

	String removeCategoryById(Long catId);
}
