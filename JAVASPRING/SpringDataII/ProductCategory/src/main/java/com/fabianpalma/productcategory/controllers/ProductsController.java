package com.fabianpalma.productcategory.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fabianpalma.productcategory.models.Category;
import com.fabianpalma.productcategory.models.CategoryProduct;
import com.fabianpalma.productcategory.models.Product;
import com.fabianpalma.productcategory.services.CategoryProductService;
import com.fabianpalma.productcategory.services.CategoryService;
import com.fabianpalma.productcategory.services.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductsController {

	//PRODUCTO SERVICE
	private final ProductService productService;
	
	//CATEGORY SERVICE
	private final CategoryService categoryService;
	private final CategoryProductService categoryProductService;
	
	
	
	public ProductsController(ProductService productService, CategoryService categoryService, CategoryProductService categoryProductService) {
		this.productService= productService;
		this.categoryService = categoryService;
		this.categoryProductService = categoryProductService;
	}
	
	@GetMapping("/new")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product()); // Crear una nueva instancia de Product para el formulario
        return "product.jsp";
    }

    @PostMapping("/new")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product.jsp"; // Si hay errores, mostrar el formulario de creación nuevamente con los mensajes de error
        } else {
            productService.createProduct(product);
            return "redirect:/products/new"; // Redirigir al usuario a la página de creación de productos
        }
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model) {
    	Optional<Product> optionalProduct = productService.encontrarProductPorId(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            List<Category> categories = categoryService.nullCategory(product);
            model.addAttribute("categories", categories); 
            model.addAttribute("product", product);
            return "showProduct.jsp";
        } else {
            // Manejar la situación cuando no se encuentra el producto con el ID proporcionado
            // Puedes redirigir a una página de error o realizar alguna otra acción
            return "error.jsp";
        }
    }


    @PostMapping("/{id}")
    public String createCategoryProduct(@ModelAttribute("category_product") CategoryProduct categoryproduct, @PathVariable("id") Long id, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/products/" + id; // Redirigir al usuario a la página de detalles del producto en caso de errores
        } else {
            categoryProductService.createCategoryProduct(categoryproduct);
            return "redirect:/products/" + id; // Redirigir al usuario a la página de detalles del producto después de crear la relación
        }
    }
}
