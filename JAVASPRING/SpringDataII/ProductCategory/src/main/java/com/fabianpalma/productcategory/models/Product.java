package com.fabianpalma.productcategory.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=5, max=45, message="El nombre del producto debe contener entre 5 a 45 caracteres.")
	private String name;
	
	@Size(min=5, max=45, message="La descripcion del producto debe contener entre 5 a 45 caracteres.")
	private String description;
	
	@Min(value = 10, message = "El precio no debe ser inferior a 10.")
    @Max(value = 999999999, message = "El precio no debe ser mayor a 999999999.")
    private int price;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "product_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
    
	/**
	 * Controller Constructor
	 * */
	public Product() {
		
	}
	/**
	 * API CONSTRUCTOR
	 * */
	public Product(
			@Size(min = 5, max = 45, message = "El nombre del producto debe contener entre 5 a 45 caracteres.") String name,
			@Size(min = 5, max = 45, message = "La descripcion del producto debe contener entre 5 a 45 caracteres.") String description,
			@Size(min = 2, max = 9, message = "El precio no debe ser inferior de 10 y mayor de 999999999") @Min(10) @Max(999999999) int price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	//GETTERS AND SETTERS;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
		/**
		 * DATE creator
		 * */
		
		@PrePersist
	    protected void onCreate() {
	        this.createdAt = new Date();
	        this.updatedAt = new Date();
	    }
	
		@PreUpdate
	    protected void onUpdate() {
	        this.updatedAt = new Date();
	    }
		
}