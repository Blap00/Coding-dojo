package com.CodingDojo.maestroDeObjetosII;

public class HumanTest {
    public static void main(String[] args) {
    	Human humano = new Human();
        Wizard mago = new Wizard();
        Ninja ninja = new Ninja();
        Samurai samurai = new Samurai();

        System.out.println("Salud del humano: " + humano.getHealth());
        System.out.println("Salud del mago: " + mago.getHealth());
        System.out.println("Salud del ninja: " + ninja.getHealth());
        System.out.println("Salud del samurái: " + samurai.getHealth());
        System.out.println("Cantidad de samuráis: " + Samurai.howMany());
        
        mago.heal(humano);
        ninja.steal(humano);
        samurai.deathBlow(humano);

        System.out.println("Salud del humano después de ser curado, robado y atacado: " + humano.getHealth());
        System.out.println("Salud del mago después de curar: " + mago.getHealth());
        System.out.println("Salud del ninja después de robar: " + ninja.getHealth());
        System.out.println("Salud del samurái después de usar el golpe mortal: " + samurai.getHealth());

        mago.fireBall(ninja);
        ninja.runAway();
        samurai.meditate();

        System.out.println("Salud del ninja después de la bola de fuego y escaparse: " + ninja.getHealth());
        System.out.println("Salud del samurái después de meditar: " + samurai.getHealth());

    }
}
