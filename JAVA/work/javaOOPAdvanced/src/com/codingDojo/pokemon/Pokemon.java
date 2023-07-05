package com.codingDojo.pokemon;

public class Pokemon{
	//VARIABLE PRIVADAS
	private String name;
	private double health;
	private String type;
	//VARIABLE CONSTANTES
	public static int count=0;
	//Constructor
	public Pokemon(String name, double health, String type) {
		this.name = name;
		this.health = health;
		this.type = type;
		count++;
	}
	//GETTER AND SETTER
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Pokemon.count = count;
	}
	//Attack
	public void attackPokemon(Pokemon pokemon) {
        pokemon.health -= 10;
    }
}