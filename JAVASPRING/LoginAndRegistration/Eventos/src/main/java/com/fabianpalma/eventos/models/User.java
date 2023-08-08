package com.fabianpalma.eventos.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
    @GeneratedValue()
	private Long id;

	@Size(min=5, message="El nombre debe contener sobre 5 caracteres")
    @Size(max=55, message="El nombre debe contenter menos de 55 caracteres")
    @NotNull(message="El nombre debe tener algo escrito!")
	@Column(columnDefinition = "VARCHAR(55)")
	private String firstName;
	
	@Size(min=2, message="El apellido debe contener sobre 2 caracteres")
    @Size(max=55, message="El apellido debe contenter menos de 55 caracteres")
    @NotNull(message="El apellido deben tener algo escrito!")
	@Column(columnDefinition = "VARCHAR(55)")
	private String lastName;
	
	@Size(min=5, message="El email debe contener sobre 5 caracteres")
    @Size(max=170, message="El email debe contenter menos de 170 caracteres")
    @NotNull(message="El email deben tener algo escrito!")
	@Column(columnDefinition = "VARCHAR(170)")
	private String email;

    @NotNull(message="La contraseñas deben tener algo escrito!")
	@Column(columnDefinition = "VARCHAR(65)")
	private String password;
	
	@Transient
    private String passwordConfirmation;
	
	@Size(min=5, message="La direccion debe contener sobre 5 caracteres")
    @Size(max=60, message="La direccion debe contenter menos de 60 caracteres")
    @NotNull(message="Las direcciones deben tener algo escrito!")
	@Column(columnDefinition = "VARCHAR(60)")
	private String location;
	
	@Column(columnDefinition = "ENUM('NY', 'CA', 'AZ', 'WA', 'TX', 'FL', 'IL', 'CO', 'NC', 'GA')")
	private String state;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    
    
    public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
    	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
    
}
