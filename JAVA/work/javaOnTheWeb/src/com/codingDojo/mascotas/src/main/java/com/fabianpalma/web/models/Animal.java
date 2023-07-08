package com.fabianpalma.web.models;

public abstract class Animal {
	protected String name;
	protected double weight;
	protected String breed;
	//SOBREPOBLAR CONSTRUCTORES
	public Animal() {
		this.name = "No Existe";
		this.weight = 0;
		this.breed = "No";
	}
	public Animal(String name, double weight, String breed) {
		this.name = name;
		this.weight = weight;
		this.breed = breed;
	}
	//GET AND SET
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight2) {
		this.weight = weight2;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}

	
	
	
	
	
}