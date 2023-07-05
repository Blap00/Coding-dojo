package com.CodingDojo.GuardiaZoologicoP2;

public class Gorilla extends Mammal{
	
	public Gorilla(int energy) {
		super(energy);
	}
	public void throwSomething() {
		System.out.println("El gorila ha lanzado una roca.");
		setEnergyLevel(getEnergyLevel()-5);
	}
	public void eatBananas(){
		System.out.println("El gorila se siente feliz por haber comido una banana!");
		setEnergyLevel(getEnergyLevel()+10);
	}
	public void climb() {
		System.out.println("El gorila ha escalado un arbol, muy cansador!");
		setEnergyLevel(getEnergyLevel()-10);
	}
}

/*
//CON ERROR
public class Gorilla{
	Mammal energ= new Mammal(100);
	public void throwSomething() {
		System.out.println("El gorila ha lanzado una roca.");
		energ.setEnergyLevel(energ.getEnergyLevel()-5);
	}
	public void eatBananas(){
		System.out.println("El gorila se siente feliz por haber comido una banana!");
		energ.setEnergyLevel(energ.getEnergyLevel()+10);
	}
	public void climb() {
		System.out.println("El gorila ha escalado un arbol, muy cansador!");
		energ.setEnergyLevel(energ.getEnergyLevel()-10);
	}
}
//ERROR, NO EXTENDIO, no estaba aplicando herencia	
 */