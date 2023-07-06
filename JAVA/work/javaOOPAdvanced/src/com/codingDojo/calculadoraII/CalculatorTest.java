package com.codingDojo.calculadoraII;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.performOperation(10.5);
        calculator.performOperation("+");
        calculator.performOperation(5.2);
        calculator.performOperation("*");
        calculator.performOperation(10);
        calculator.getResults(); //RESULT: 62.5
    }
}
