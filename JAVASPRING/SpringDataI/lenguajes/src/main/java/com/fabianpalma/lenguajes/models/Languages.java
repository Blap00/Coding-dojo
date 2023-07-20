package com.fabianpalma.lenguajes.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@Table(name="languages")
public class Languages {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 20, message = "El nombre deberia tener entre 2 y 20 caracteres")
    private String name;

    @Size(min = 2, max = 20, message = "El creador deberia tener entre 2 y 20 caracteres")
    private String creator;

    @NotNull(message = "La version actual no puede ser nula")
    @Min(value = 1, message = "La version actual deberia ser como minimo 1")
    private Float currentVersion;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    public Languages() {
    }
    
    
    public Languages(String name, String creator,Float currentVersion) {
		this.name = name;
		this.creator = creator;
		this.currentVersion = currentVersion;
	}
    
    //GETERS AND SETTERS
    
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


	public String getCreator() {
		return creator;
	}


	public void setCreator(String creator) {
		this.creator = creator;
	}


	public Float getCurrentVersion() {
		return currentVersion;
	}


	public void setCurrentVersion(Float currentVersion) {
		this.currentVersion = currentVersion;
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
    
    //CREATE AND UPDATE METHODS


	@PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

	@PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
