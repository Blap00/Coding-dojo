package com.codingDojo.calculadoraI;

public class Calculator {
    private double operandOne;
    private double operandTwo;
    private String operation;
    private double result;

    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne;
    }

    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void performOperation() {
        switch (operation) {
            case "+":
                result = operandOne + operandTwo;
                break;
            case "-":
                result = operandOne - operandTwo;
                break;
            default:
                System.out.println("Invalid operation");
        }
    }

    public double getResult() {
        return result;
    }
}
