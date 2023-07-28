package com.fabianpalma.springdata.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="autor")
public class Autor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Size(min = 2, message="El nombre debe contener sobre 2 caracteres")
    @Size(max = 50, message="El nombre debe contener menos de 50 caracteres")
    private String nombre;
    
    @Size(min = 2, message="El nombre debe contener sobre 2 caracteres")
    @Size(max = 50, message="El nombre debe contener menos de 50 caracteres")
    private String apellido;
    
    @Size(min = 2, message="El nombre debe contener sobre 2 caracteres")
    @Size(max = 100, message="El nombre debe contener menos de 50 caracteres")
    private String description;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
//    @OneToMany(mappedBy = "autor")
//    private List<Book> books;
	public Autor() {
	}
	public Autor(
			@Size(min = 2, message = "El nombre debe contener sobre 2 caracteres") @Size(max = 50, message = "El nombre debe contener menos de 50 caracteres") String nombre,
			@Size(min = 2, message = "El nombre debe contener sobre 2 caracteres") @Size(max = 50, message = "El nombre debe contener menos de 50 caracteres") String apellido,
			@Size(min = 2, message = "El nombre debe contener sobre 2 caracteres") @Size(max = 100, message = "El nombre debe contener menos de 50 caracteres") String description) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
//	public List<Book> getBooks() {
//		return books;
//	}
//	public void setBooks(List<Book> books) {
//		this.books = books;
//	}
	
	// Otros getters y setters fueron removidos para resumir
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
	
    
}
