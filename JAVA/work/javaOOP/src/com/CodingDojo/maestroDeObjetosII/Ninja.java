package com.CodingDojo.maestroDeObjetosII;

public class Ninja extends Human {
    public Ninja() {
        super();
        this.health = 100;
        this.stealth = 10;
    }

    public void steal(Human target) {
        int stolenHealth = this.stealth;
        target.health -= stolenHealth;
        this.health += stolenHealth;
        System.out.println("Ninja stole health from another Human! Stolen health: " + stolenHealth);
    }

    public void runAway() {
        this.health -= 10;
        System.out.println("Ninja ran away! Health reduced by 10");
    }
}
