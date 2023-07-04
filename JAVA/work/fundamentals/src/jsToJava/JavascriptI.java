package jsToJava;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.text.DecimalFormat;

public class JavascriptI {	
	//EJERCICIO 1
	public static int[] print1To255() {
        ArrayList<Integer> newArr = new ArrayList<>();
        for (int i = 1; i <= 255; i++) {
            newArr.add(i);
        }
        return newArr.stream().mapToInt(Integer::intValue).toArray();
        /*
 			
			newArr.stream(): Convierte el ArrayList en un flujo (Stream) de elementos. Un flujo es una 
			secuencia de elementos que se puede procesar de forma encadenada.

			mapToInt(Integer::intValue): Utiliza la función de mapeo mapToInt() para transformar cada 
			elemento del flujo en su representación entera. En este caso, se utiliza la referencia al 
			método Integer::intValue para obtener el valor entero de cada elemento.

			toArray(): Convierte el flujo de elementos en un array de enteros (int[]). El método 
			toArray() crea un nuevo array y coloca los elementos del flujo en ese array.
        */
    }
	//EJERCICIO 2
	public static int sumaParesHasta1000() {
        int suma = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i % 2 == 0) {
                suma += i;
            }
        }
        return suma;
    }
	//EJERCICIO 3
    public static int sumaImparesHasta5000() {
        int suma = 0;
        for (int i = 1; i <= 5000; i++) {
            if (i % 2 != 0) {
                suma += i;
            }
        }
        return suma;
    }
    //EJERCICIO 4
    public static int sumaArray(int[] arr) {
        int suma = 0;
        for (int i = 0; i < arr.length; i++) {
            suma += arr[i];
        }
        return suma;
    }
    //EJERCICIO 6
    public static int encontrarMayor(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    //EJERCICIO 7
    public static double calcularPromedio(int[] arr) {
        int suma = 0;
        for (int i = 0; i < arr.length; i++) {
            suma += arr[i];
        }
        return (double) suma / arr.length;
    }
    //EJERCICIO 8
    public static int[] obtenerImparesHasta50() {
    	ArrayList<Integer> impares = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            if (i % 2 != 0) {
                impares.add(i); //JS= push, Java= add
            }
        }
        return convertIntegerListToArray(impares);
    }
    //EJERCICIO 9
    public static int contarMayoresQueY(int[] arr, int y) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > y) { //Obtuve un error, necesitaba siempre tener los parametros en minuscula
                count++;
            }
        }
        return count;
    }
    //EJERCICIO 10
    public static int[] cuadrados(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        return arr;
    }
    //EJERCICIO 11
    public static int[] reemplazarNegativosPorCero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }
        return arr;
    }
    //EJERCICIO 12
    public static double[] maxMinAvg(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            else if (arr[i] < min) {
                min = arr[i];
            }
            sum += arr[i];
        }
        double average = (double) sum / arr.length;
        return new double[]{max, min, average};
    }
    //EJERCICIO 13
    public static int[] intercambiarValores(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
        return arr;
    }
    //EJERCICIO 14
    public static String[] convertirNegativosADojo(int[] arr) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                result[i] = "Dojo";
            } else {
                result[i] = String.valueOf(arr[i]);
            }
        }
        return result;
    }
    //EJERCICIO 15
    private static int[] convertIntegerListToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    //PRINT SEPARATION LINES
    public static void printSeparatorLine() {
        System.out.println("_______||||_______");
    }
    
    /*
    public static int[] negativoToZero(int[] arr){
            int[] newArr = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
            	if(arr[i]<0) {
            		newArr[i]= 0;
            	}else {
            		newArr[i]= arr[i];
            	}
            }
            return newArr ;       
    }
    */
    //
     public static void main(String[] args) {
        int[] numbers = {5, 9, 3, 7, 2, 1, 8, 6, 4}; //ARRAY PRINCIPAL DE TODOS LOS VALORES
        //PROCEDE A LLAMAR TODAS LAS FUNCINES Y SUS VALORES
        int[] result1 = print1To255();
        int result2 = sumaParesHasta1000();
        int result3 = sumaImparesHasta5000();
        int result4 = sumaArray(numbers);
        int result5 = encontrarMayor(numbers);
        double result6 = calcularPromedio(numbers);
        int[] result7 = obtenerImparesHasta50();
        int result8 = contarMayoresQueY(numbers, 5);
        int[] result9 = cuadrados(numbers);
        int[] result10 = reemplazarNegativosPorCero(numbers);
        double[] result11 = maxMinAvg(numbers);
        int[] result12 = intercambiarValores(numbers);
        String[] result13 = convertirNegativosADojo(numbers);

        System.out.println("Del 1 al 255: " + Arrays.toString(result1));
        printSeparatorLine();
        System.out.println("Suma de pares hasta 1000: " + result2);
        printSeparatorLine();
        System.out.println("Suma de impares hasta 5000: " + result3);
        printSeparatorLine();
        System.out.println("Suma del array: " + result4);
        printSeparatorLine();
        System.out.println("Mayor valor del array: " + result5);
        printSeparatorLine();
        System.out.println("Promedio del array: " + result6);
        printSeparatorLine();
        System.out.println("Impares hasta 50: " + Arrays.toString(result7));
        printSeparatorLine();
        System.out.println("Cantidad de números mayores que 5: " + result8);
        printSeparatorLine();
        System.out.println("Cuadrados del array: " + Arrays.toString(result9));
        printSeparatorLine();
        System.out.println("Reemplazar negativos por cero: " + Arrays.toString(result10));
        printSeparatorLine();
        System.out.println("Max del array: " + ((int)result11[0]));
        System.out.println("Min del array: " + ((int)result11[1]));
        System.out.println("Avg del array: " + new DecimalFormat("0.00").format(result11[2]));//DECIMAL FORMAT ME AYUDA A FORMATEAR LA VARIABLE Y MODIFICAR SU ENTREGA A UN VALOR ESPECIFICO
        printSeparatorLine();
        System.out.println("Array con valores intercambiados: " + Arrays.toString(result12));
        printSeparatorLine();
        System.out.println("Convertir negativos a 'Dojo': " + Arrays.toString(result13));
        printSeparatorLine();
    }
    
}
