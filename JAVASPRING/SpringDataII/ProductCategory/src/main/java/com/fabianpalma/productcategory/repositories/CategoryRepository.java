package com.fabianpalma.productcategory.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabianpalma.productcategory.models.Category;
import com.fabianpalma.productcategory.models.Product;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	//GET ALL
	List<Category> findAll();
	//Encontrar aquellos que no contengan;
	List<Category> findByProductsNotContains(Product product);	
	//ENCONTRAR POR ID
	Optional<Category> findById(Long id);
}
