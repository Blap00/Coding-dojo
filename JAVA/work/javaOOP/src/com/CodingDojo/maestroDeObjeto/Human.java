package com.CodingDojo.maestroDeObjeto;

public class Human {
    private int strength;
    private int intelligence;
    private int stealth;
    private int health;

    public Human() {
        this.strength = 3;
        this.intelligence = 3;
        this.stealth = 3;
        this.health = 100;
    }

    public void attack(Human target) {
        int damage = this.strength;
        target.health -= damage;
        System.out.println("Human attacked! Damage inflicted: " + damage);
    }

    // Getters and setters

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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
