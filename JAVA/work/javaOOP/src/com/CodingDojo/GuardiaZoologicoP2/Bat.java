package com.CodingDojo.GuardiaZoologicoP2;

public class Bat extends Mammal{
//    private int energy;
	

    public Bat(int energy) {
		super(energy);

	}

	public void fly() {
        System.out.println("*SONIDO DE MURCIÉLAGO AL DESPEGAR*");
        setEnergyLevel(getEnergyLevel() - 50);
//      energy -=50;
    }

    public void eatHumans() {
        System.out.println("Bueno, no importa.");
        setEnergyLevel(getEnergyLevel() + 25);
//        energy += 25;
    }

    public void attackTown() {
        System.out.println("*SONIDO DE CIUDAD EN LLAMAS*");
        setEnergyLevel(getEnergyLevel() - 100);
//        energy -= 100;
    }
}

