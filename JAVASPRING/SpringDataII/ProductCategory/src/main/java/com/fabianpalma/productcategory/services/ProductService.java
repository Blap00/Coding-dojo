package com.fabianpalma.productcategory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.productcategory.models.Category;
import com.fabianpalma.productcategory.models.Product;
import com.fabianpalma.productcategory.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> findProductsNotInCategoryWithId(Long categoryId) {
        Category category = new Category();
        category.setId(categoryId);
        return productRepository.findByCategoriesNotContaining(category);
    }

	// Devolviendo todos los personas.
	public List<Product> allProduct() {
		return productRepository.findAll();
	}

	public Optional<Product> encontrarProductPorId(Long id) {
		return productRepository.findById(id);
	}

	// Creando un persona.
	public Product createProduct(Product b) {
		return productRepository.save(b);
	}
}
