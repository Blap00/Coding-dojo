package com.CodingDojo.GuardiaZoologicoP2;

public class BatTest {
    public static void main(String[] args) {
        Bat bat = new Bat();

        // Atacar la ciudad tres veces
        bat.attackTown();
        bat.attackTown();
        bat.attackTown();

        // Comer dos humanos
        bat.eatHumans();
        bat.eatHumans();

        // Volar dos veces
        bat.fly();
        bat.fly();

        // Mostrar nivel de energía final
        System.out.println("Nivel de energía final: " + bat.getEnergy());
    }
}
