package com.codingDojo.pokemon;

public class PokedexTest {
    public static void main(String[] args) {
        Pokedex pokedex = new Pokedex();
        //Declaro los Pokemones presentes en el sistema
        Pokemon pikachu = pokedex.createPokemon("Pikachu", 100, "Electric");
        Pokemon charmander = pokedex.createPokemon("Charmander", 80, "Fire");
        //Pokemon pikachu ataca al pokemon Charmander
        pikachu.attackPokemon(charmander);
        //Muestra la informacion de Pikachu
        System.out.println(pokedex.pokemonInfo(pikachu));
        //Muestra informacion de Charmander
        System.out.println(pokedex.pokemonInfo(charmander));
        //Añade a la lista los pokemones;
        pokedex.addPokemon(pikachu);
        pokedex.addPokemon(charmander);
        //Muestra una lista de pokemones
        pokedex.listPokemon();
    }
}
