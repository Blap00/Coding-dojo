package com.CodingDojo.maestroDeObjetosII;

public class Samurai extends Human {
    private static int samuraiCount = 0;

    public Samurai() {
        super();
        this.health = 200;
        samuraiCount++;
    }

    public void deathBlow(Human target) {
        int targetHealth = target.health;
        target.health = 0;
        this.health /= 2;
        System.out.println("Samurai used Death Blow! Target health reduced to 0. Samurai health reduced by half. Target health before: " + targetHealth);
    }

    public void meditate() {
        int healingAmount = this.health / 2;
        this.health += healingAmount;
        System.out.println("Samurai meditated! Health increased by " + healingAmount);
    }

    public static int howMany() {
        return samuraiCount;
    }
}
