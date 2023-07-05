package com.CodingDojo.GuardiaZoologicoP2;

public class BatTest {
    public static void main(String[] args) {
        Bat bat = new Bat(300);

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
        bat.displayEnergy();
        
        
        //GORILLA TEST
        
        Gorilla gor= new Gorilla(100);
		gor.throwSomething();
		gor.throwSomething();
		gor.throwSomething();
		gor.eatBananas();
		gor.eatBananas();
		gor.climb();
		
		gor.displayEnergy();
    }
}
/*
//NUEVA VERSION
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
       System.out.println("Nivel de energía final: " + bat.getEnergyLevel());
   }
}
*/
