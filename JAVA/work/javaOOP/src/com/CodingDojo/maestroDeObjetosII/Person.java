package com.CodingDojo.maestroDeObjetosII;

public class Person {
    protected int strength;
    protected int intelligence;
    protected int stealth;

    public Person() {
        this.strength = 3;
        this.intelligence = 3;
        this.stealth = 3;
    }

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}
    
    
    
}
