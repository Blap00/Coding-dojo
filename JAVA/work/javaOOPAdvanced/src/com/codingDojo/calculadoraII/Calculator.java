package com.codingDojo.calculadoraII;
//USE JAVA STACK, //https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
//ES SIMILAR A UNO DE ARRAYS, PERO BIEN ESTE NO REQUIERE DE UN ARRAY, ES UNA LISTA POR SI MISMO
import java.util.Stack;

public class Calculator {
	//set variables numbers & operators
    private Stack<Double> numbers;
    private Stack<String> operators;
    //Set Constructor
    public Calculator() {
        numbers = new Stack<>();
        operators = new Stack<>();
    }
    //Set numbers when the params is double, add it to a List
    public void performOperation(double operand) {
        numbers.push(operand);
    }
    //set operators when the params hit a String "", add it to a List
    public void performOperation(String operator) {
        operators.push(operator);
    }
    //It get the result when is available and not empty
    public void getResults() {
        calculateResult();
        if (!numbers.isEmpty()) {
            System.out.println("Result: " + numbers.peek());
        } else {
            System.out.println("No result available.");
        }
    }
    //It will calculate the result on calculator
    private void calculateResult() {
    	//Mientras los sea distinto de que los operadores esten vacios
        while (!operators.isEmpty()) {
        	//El string Operador se declara con el valor de operators.pop()
        	/*
        	 * .pop
        	 * 
			 * Elimina el objeto en la parte superior de esta pila y devuelve ese objeto como el valor de esta función.
			 * 
        	 * */
            String operator = operators.pop();
            if (operator.equals("=")) { //Si el operador es "="
                break; //Rompe el ciclo
            }
            if (numbers.size() < 2) {//Si la cantidad de datos es menor a 2 
                System.out.println("Invalid number of operands and operations"); //Mensaje error
                return; //retorna vacio, rompe el metodo
            }
            double operand2 = numbers.pop(); // Operand 2 se declara con el ultimo valor 
            double operand1 = numbers.pop(); // lo mismo de arriba
            double result = performOperation(operand1, operand2, operator); // Declara Resultado con el valor entregado por una funcion
            numbers.push(result); //Declara como ultimo valor el resultado de la operacion
        }
    }

    private double performOperation(double operand1, double operand2, String operator) {
        switch (operator) { //Es como un if solo que un tanto más sencillo
            case "+": //Si el STRING operador es == "+"
                return operand1 + operand2;
            case "-": //Si el STRING operador es == "-"
                return operand1 - operand2;
            case "*": //Si el STRING operador es == "*"
                return operand1 * operand2;
            case "/": //Si el STRING operador es == "/"
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    System.out.println("Cannot divide by zero");
                    return 0.0;
                }
            default:
                System.out.println("Invalid operator: " + operator);
                return 0.0;
        }
    }
}
