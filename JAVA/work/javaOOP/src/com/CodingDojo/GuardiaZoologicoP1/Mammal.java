package com.CodingDojo.GuardiaZoologicoP1;

public class Mammal{
	private int energyLevel;

	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
		System.out.println("ENERGYLEVEL de GORRILLA; "+energyLevel);
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