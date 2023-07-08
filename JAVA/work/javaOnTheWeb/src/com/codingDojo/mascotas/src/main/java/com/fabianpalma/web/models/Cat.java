package com.fabianpalma.web.models;

public class Cat extends Animal implements Pet {
	public Cat(String name, String breed, Double weight) {
		super(name,weight,breed);
	}
	@Override
	public String showAffection() {
		return "Your " + this.breed + " cat, " + this.name + ", looked at you with some affection. You think.";
	}

}