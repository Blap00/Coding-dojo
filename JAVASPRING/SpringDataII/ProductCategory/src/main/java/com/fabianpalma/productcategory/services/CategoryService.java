package com.fabianpalma.productcategory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.productcategory.models.Category;
import com.fabianpalma.productcategory.models.Product;
import com.fabianpalma.productcategory.repositories.CategoryRepository;

@Service
public class CategoryService {
	// Agregando repositorio de categoria como una dependencia
	@Autowired
	private final CategoryRepository categoryRepository;
	//Constructor
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	//GET ALL ON CATEGORIES (R)
	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}
	//Get a null category
	public List<Category> nullCategory(Product product) {
		return categoryRepository.findByProductsNotContains(product);
	}
	
	//GET by ID
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}
	
	//Create or Upadte
	public Category createCategory(Category b) {
		return categoryRepository.save(b);
	}
	//Delete
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

}