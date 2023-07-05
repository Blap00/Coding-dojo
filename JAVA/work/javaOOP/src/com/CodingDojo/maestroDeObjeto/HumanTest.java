package com.CodingDojo.maestroDeObjeto;

public class HumanTest {
    public static void main(String[] args) {
        Human player1 = new Human();
        Human player2 = new Human();

        System.out.println("Salud de Player 1: " + player1.getHealth());
        System.out.println("Salud de Player 2: " + player2.getHealth());

        player1.attack(player2);

        System.out.println("Salud de Player 1: " + player1.getHealth());
        System.out.println("Salud de Player 2: " + player2.getHealth());
    }
}
