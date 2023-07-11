package com.fabianpalma.web.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomWordGenerator {
    private String randomWord;
    private int counter;
    private String lastGeneratedTime;

    public void generateRandomWord() {
        int wordLength = 10; // Longitud de la palabra aleatoria
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < wordLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        randomWord = sb.toString();
        counter++;
        lastGeneratedTime = getCurrentDateTime();
    }

    public String getRandomWord() {
        return randomWord;
    }

    public int getCounter() {
        return counter;
    }

    public String getLastGeneratedTime() {
        return lastGeneratedTime;
    }

    private String getCurrentDateTime() {
        // Obtener el formato de fecha y hora actual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Obtener la fecha y hora actual en formato de cadena
        return LocalDateTime.now().format(formatter);
    }
}
