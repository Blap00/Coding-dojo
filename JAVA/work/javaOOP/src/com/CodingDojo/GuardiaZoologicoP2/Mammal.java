package com.CodingDojo.GuardiaZoologicoP2;

public class Mammal{
	private int energyLevel;

	public Mammal(int energy) {
		this.energyLevel= energy;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	public double displayEnergy() {
		System.out.println("La energia actual del Mammal es; "+this.energyLevel);
		return energyLevel;
	}
}
