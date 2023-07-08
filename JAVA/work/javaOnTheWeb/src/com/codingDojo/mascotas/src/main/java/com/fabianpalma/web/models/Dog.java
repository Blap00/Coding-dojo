package com.fabianpalma.web.models;

public class Dog extends Animal implements Pet {
	
	public Dog(String name, String breed, Double weight) {
		super(name, weight, breed );
	}
	@Override
	public String showAffection() {
		if(this.weight < 30) {
			return this.name + " hopped into on your lap and cuddled you!";
		}
		else {
			return this.name + " curled up next to you.";
		} 
	}
	
}