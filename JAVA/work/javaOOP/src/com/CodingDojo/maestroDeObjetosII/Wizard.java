package com.CodingDojo.maestroDeObjetosII;

public class Wizard extends Human {
    public Wizard() {
        super();
        this.health = 50;
        this.intelligence = 8;
    }

    public void heal(Human target) {
        int healingAmount = this.intelligence;
        target.health += healingAmount;
        System.out.println("Wizard healed another Human! Health increased by " + healingAmount);
    }

    public void fireBall(Human target) {
        int damage = this.intelligence * 3;
        target.health -= damage;
        System.out.println("Wizard casted Fireball! Target health reduced by " + damage);
    }
}
