package com.fabianpalma.web.models;

import java.util.Random;

public class GuessModel {
    private int generatedNumber;
    private int userGuess;
    private String message;

    public void generateNumber() {
        Random random = new Random();
        generatedNumber = random.nextInt(100) + 1;
    }

    public void setUserGuess(int guess) {
        userGuess = guess;
    }
    
    public void checkGuess() {
        if (userGuess == generatedNumber) {
            message = "¡Felicitaciones! ¡Adivinaste el número correcto!";
        } else if (userGuess < generatedNumber) {
            message = "El número es demasiado bajo. ¡Inténtalo de nuevo!";
        } else {
            message = "El número es demasiado alto. ¡Inténtalo de nuevo!";
        }
    }

    public String getMessage() {
        return message;
    }
}
