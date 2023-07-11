package com.fabianPalma.web.models;

public class clickerModelo {
	private int counter;

    public clickerModelo() {
        this.counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        counter++;
    }
}
