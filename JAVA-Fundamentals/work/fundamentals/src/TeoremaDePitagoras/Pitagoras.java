package TeoremaDePitagoras;

import java.util.Scanner;

public class Pitagoras {
    public static void main(String[] args) {
        // Crea una instancia de la clase Pitagoras
        PitagorasTest pitagorastest = new PitagorasTest();

        // Crea un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Lee el valor del primer cateto
        System.out.println("Ingrese la longitud del primer cateto: ");
        int catetoA = scanner.nextInt();

        // Lee el valor del segundo cateto
        System.out.println("Ingrese la longitud del segundo cateto: ");
        int catetoB = scanner.nextInt();

        // Calcula la hipotenusa utilizando el método calcularHipotenusa de la instancia de Pitagoras
        double hipotenusa = pitagorastest.calcularHipotenusa(catetoA, catetoB);

        // Imprime el resultado
        System.out.println("La hipotenusa entregada por los catetos es de: " + hipotenusa);

        // Cierra el objeto Scanner
        scanner.close();
    }
}
