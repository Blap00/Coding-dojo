package com.CodingDojo.maestroDeObjeto;

public class Human extends Person {
    private int health;

    public Human() {
        super(); // Llama al constructor de la clase padre (Person)
        this.health = 100;
    }

    public int getHealth() {
		return health;
	}



	public void setHealth(int health) {
		this.health = health;
	}



	public void attack(Human target) {
        int damage = this.strength;
        target.health -= damage;
        System.out.println("El humano ataco! La salud se reduce en; " + damage);
    }
}
