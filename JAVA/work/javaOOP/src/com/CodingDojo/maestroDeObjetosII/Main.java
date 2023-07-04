package com.CodingDojo.maestroDeObjetosII;

public class Main {
    public static void main(String[] args) {
        Human target = new Human();
        Wizard wizard = new Wizard();
        Ninja ninja = new Ninja();
        Samurai samurai = new Samurai();
        //ACTIVIDAD DEL WIZARD
        wizard.heal(target);
        wizard.fireBall(target);
        //ACTIVIDAD DEL NINJA
        ninja.steal(target);
        ninja.runAway();
        //ACTIVIDAD DEL SAMURAI
        samurai.deathBlow(target);
        samurai.meditate();


        System.out.println("Numero de samurais: " + Samurai.howMany());
    }
}
