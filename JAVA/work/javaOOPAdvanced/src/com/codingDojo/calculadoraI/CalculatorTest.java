package com.codingDojo.calculadoraI;

public class CalculatorTest {
    public static void main(String[] args) {
    	//Instanciar calculadora
        Calculator calculator = new Calculator();
        //SET PRIMER DATO
        calculator.setOperandOne(10.5);
        //SET OPERADOR
        calculator.setOperation("+");
        //SET SEGUNDO DATO
        calculator.setOperandTwo(5.2);
        //REALIZA LA OPERACION
        calculator.performOperation();
        // Crea una variable con el resultado de operación
        double result = calculator.getResult();
        //Imprime el resultado
        System.out.println("Result: " + result); // Result: 15.7
    }
}
