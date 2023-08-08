package com.fabianpalma.eventos.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=5, message="El nombre del evento debe contener sobre 5 caracteres")
    @Size(max=55, message="El nombre del evento debe contenter menos de 55 caracteres")
    @NotNull(message="El nombre del evento deben tener algo escrito!")
	@Column(columnDefinition = "VARCHAR(55)")
	private String name;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@Size(min=5, message="La localizacion del evento debe contener sobre 5 caracteres")
    @Size(max=55, message="La localizacion del evento debe contenter menos de 55 caracteres")
    @NotNull(message="La localizacion del evento deben tener algo escrito!")
	@Column(columnDefinition = "VARCHAR(55)")
	private String location;
	
	@Column(columnDefinition = "ENUM('NY', 'CA', 'AZ', 'WA', 'TX', 'FL', 'IL', 'CO', 'NC', 'GA')")
	private String state;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
    private User host;
    

    
    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	public Event() {
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}
	
	

}
