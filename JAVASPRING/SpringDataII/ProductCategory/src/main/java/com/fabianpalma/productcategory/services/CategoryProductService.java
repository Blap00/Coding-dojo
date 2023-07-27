package com.fabianpalma.productcategory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.productcategory.models.CategoryProduct;
import com.fabianpalma.productcategory.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {
	// Agregando el licencia al repositorio como una dependencia
	@Autowired
	private final CategoryProductRepository categoryProductRepository;
	//Constructor
	public CategoryProductService(CategoryProductRepository categoryProductRepository) {
		this.categoryProductRepository = categoryProductRepository;
	}

	//GET all 
	public List<CategoryProduct> allCategoryProduct() {
		return categoryProductRepository.findAll();
	}

	//Create or Update
	public CategoryProduct createCategoryProduct(CategoryProduct b) {
		return categoryProductRepository.save(b);
	}
	
	//Delete
	public void deleteCategoryProduct(Long id) {
		categoryProductRepository.deleteById(id);
	}
}
