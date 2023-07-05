package com.codingDojo.pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pokedex extends AbstractPokemon {
    private List<Pokemon> myPokemons;

    public Pokedex() {
        this.myPokemons = new ArrayList<>();
    }

    @Override
    public void listPokemon() {
        System.out.println("Pokédex List:");
        System.out.println("--------------");
        for (Pokemon pokemon : myPokemons) {
            System.out.println(pokemon.getName());
        }
    }

    public void addPokemon(Pokemon pokemon) {
        myPokemons.add(pokemon);
    }
}
