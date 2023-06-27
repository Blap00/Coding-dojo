//Import methods from util.scanner
import java.util.Scanner;
//MAIN
public class Pitagoras {
    public static void main(String[] args) {
        //LLama el archivo PitagoraTest.java, asi guardando su valor y metodos al interior de esta variable
        PitagorasTest pitagoras = new PitagorasTest();
        //Prepara el scanner para obtener los datos ingresados
        Scanner scanner = new Scanner(System.in);
        //Ingresa el valor para catetoA
        System.out.println("Ingrese la longitud del primer cateto: ");
        int catetoA = scanner.nextInt();
        //Ingresa valor para catetoB
        System.out.println("Ingrese la longitud del segundo cateto: ");
        int catetoB = scanner.nextInt();
        //CALCULAR HIPOTENUSA CON LOS VALORES PRESENTES
        double hipotenusa = pitagoras.calcularHipotenusa(catetoA,catetoB);
        System.out.println("La hipotenusa entregada por los catetos es de; "+hipotenusa);        
    }

}

