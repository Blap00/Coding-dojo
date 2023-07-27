package com.fabianpalma.productcategory.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fabianpalma.productcategory.models.CategoryProduct;

public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {
	
	//GET ALL
	List<CategoryProduct> findAll();
	
	//COUNT
	Integer countBy();
	
	//Find an Id
	Optional<CategoryProduct> findById(Long id);
	
}