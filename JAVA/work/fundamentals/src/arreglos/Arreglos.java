package arreglos;

import java.util.Random;
import java.util.ArrayList;

public class Arreglos {
    public static void main(String[] args) {
    	ArrayList<Object> myNewArray = new ArrayList<Object>(); //declaramos el array como Array 
    	Random ran = new Random(); //Importamos libreria Random
    	System.out.println("Primer momento del array");
    	int count=0;//declaramos contador de arrays
    	while(count<=4){ //Mientras el contador sea menor o igual a 4
			myNewArray.add(ran.nextInt(5)); // Utilizaremos el metodo ADD de ARRAYLIST para agregar valor random int de 0 a 8 
        	count++; //Sumamos la variable de contador + 1
    	}
    	count=0; //Regresamos el contador a 0 en caso de utilizarlo más tarde
    	System.out.println("ARRAY con datos generados: "); 
    	System.out.println(myNewArray);
    	System.out.println("Copiamos el ARRAY");
    	ArrayList<Object> myNewArrayCopy = new ArrayList<Object>(myNewArray); // Creamos una copia del ArrayList
    	System.out.println(myNewArrayCopy);
    	System.out.println("\nARRAY LIMPIO");
    	myNewArrayCopy.clear(); //LIMPIAMOS EL YA EXISTENTE ARRAY
    	System.out.println("ARRAY COMPLETO");
    	System.out.println(myNewArray);
    	System.out.println("ARRAY COPIA LIMPIO");
    	System.out.println(myNewArrayCopy);
    	System.out.println("\nARRAY CONTAIN");
    	if(myNewArray.contains(1)) { //PREGUNTAMOS SI EL ARRAY YA TIENE UN VALOR 1
    		System.out.println("Contiene el numero 1");
    	}
    	else {
    		System.out.println("No contiene el numero 1");
    	}
    	System.out.println("\nEl Array que contiene en la posicion 4?: ");
    	System.out.println(myNewArray.get(3)); //ENTREGA EL VALOR EN LA POSICION 3, recuerda [0,1,2,3,4]
    	System.out.println("\nPosicion de index con el valor 1");
    	System.out.println(myNewArray.indexOf(1)); //RECUERDA QUE SE MIDE EL INDEX CON [0,1*,2,3,4]
    	System.out.println("\nEl Array esta vacio?"); 
    	System.out.println("myNewArrayCopy esta vacio? "+myNewArrayCopy.isEmpty());
    	System.out.println("myNewArray esta vacio? "+myNewArray.isEmpty());
    	System.out.println("\nRemoveremos un dato");
    	myNewArrayCopy = myNewArray;
    	System.out.println("Antes del cambio: "+myNewArray);
    	System.out.println("Eliminaremos el campo index 3");
    	System.out.println("crearemos un campo de copia para eliminar el dato y no afectar el principal");
    	myNewArrayCopy.remove(3);//eliminara en el campo index 3, recordemos que sera: [0,1,2,3*,4]
    	System.out.println("Despues de eliminar: "+ myNewArrayCopy);
    	System.out.println("\nTamaño de los arrays!");
    	System.out.println("Tamaño del Array Original: "+myNewArray.size());
    	System.out.println("Tamaño del Array Copia: "+myNewArrayCopy.size());
    }    
}