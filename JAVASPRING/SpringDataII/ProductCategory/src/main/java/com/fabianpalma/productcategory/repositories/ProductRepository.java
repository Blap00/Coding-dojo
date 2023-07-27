package com.fabianpalma.productcategory.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabianpalma.productcategory.models.Category;
import com.fabianpalma.productcategory.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
    Optional<Product> findById(Long id);

    List<Product> findByCategoriesNotContaining(Category category);
    
}